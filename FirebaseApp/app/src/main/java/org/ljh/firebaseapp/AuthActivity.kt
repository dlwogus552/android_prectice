package org.ljh.firebaseapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.GoogleAuthProvider
import org.ljh.firebaseapp.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity() {
    lateinit var binding: ActivityAuthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (MyApplication.checkAuth()) {
            changeVisibility("login")
        } else {
            changeVisibility("logout")
        }

        //인텐트 결과 받아오기
        val requestLauncher=registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()){
            val task = GoogleSignIn.getSignedInAccountFromIntent(it?.data)
            try{
                val account=task.getResult(ApiException::class.java)
                val credential= GoogleAuthProvider.getCredential(account.idToken,null)
                MyApplication.auth.signInWithCredential(credential)
                    .addOnCompleteListener(this){task->
                        if(task.isSuccessful){
                            Log.d("aaa","구글 성공")
                            MyApplication.email= account.email
                            changeVisibility("login")
                        }else{
                            Log.d("aaa","구글 실패")
                            changeVisibility("logout")
                        }
                    }
            }catch (e:Exception){e.printStackTrace()}
        }

        //구글로 인텐트 보내기
        binding.googleLoginBtn.setOnClickListener{
            val gso = GoogleSignInOptions
                .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build()
            val signInIntent=GoogleSignIn.getClient(this, gso).signInIntent
            requestLauncher.launch(signInIntent)
        }

        //회원가입폼으로
        binding.registerBtn.setOnClickListener {
            changeVisibility("signing")
            binding.authEmailEditView.text.clear()
            binding.authPasswordEditView.text.clear()
        }
        //가입버튼 클릭
        binding.signBtn.setOnClickListener {
            val email = binding.authEmailEditView.text.toString()
            val password = binding.authPasswordEditView.text.toString()

            MyApplication.auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    binding.authEmailEditView.text.clear()
                    binding.authPasswordEditView.text.clear()
                    if (task.isSuccessful) {
                        //이메일로 인증 메일발송
                        MyApplication.auth.currentUser?.sendEmailVerification()
                            ?.addOnCompleteListener { sendTask ->
                                if (sendTask.isSuccessful) { //유효성 검사 결과
                                    Toast.makeText(baseContext, "인증성공", Toast.LENGTH_SHORT).show()
                                    changeVisibility("logout")
                                }else{
                                    Toast.makeText(baseContext, "인증실패", Toast.LENGTH_SHORT).show()
                                }
                            }

                    }else{
                        Toast.makeText(baseContext, "회원가입 실패", Toast.LENGTH_SHORT).show()
                        changeVisibility("logout")
                    }
                }
        }
        //로그인 폼으로
        binding.loginBtn.setOnClickListener{
            val email = binding.authEmailEditView.text.toString()
            val password = binding.authPasswordEditView.text.toString()

            MyApplication.auth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this){task->
                    binding.authEmailEditView.text.clear()
                    binding.authPasswordEditView.text.clear()

                    if(task.isSuccessful){
                        if(MyApplication.checkAuth()){
                            MyApplication.email=email
                            changeVisibility("login")
                        }else{
                            Toast.makeText(baseContext,"전송된 이메일 인증처리가 되지 않았습니다.",Toast.LENGTH_SHORT).show()
                        }
                    }else{
                        Toast.makeText(baseContext,"로그인 실패",Toast.LENGTH_SHORT).show()
                    }
                }
        }
        //로그아웃
        binding.logoutBtn.setOnClickListener{
            MyApplication.auth.signOut()
            MyApplication.email = null
            changeVisibility("logout")
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_auth,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }

    fun changeVisibility(mode: String) {
        if (mode === "login") {
            binding.run {
                authMainTextView.text = "${MyApplication.email}님 반갑습니다."
                logoutBtn.visibility = View.VISIBLE
                loginBtn.visibility = View.GONE
                signBtn.visibility = View.GONE
                authEmailEditView.visibility = View.GONE
                authPasswordEditView.visibility = View.GONE
                googleLoginBtn.visibility = View.GONE
                registerBtn.visibility = View.GONE

            }
        } else if (mode === "logout") {
            binding.run {
                authMainTextView.text = "로그인 하거나 회원가입 해주세요."
                logoutBtn.visibility = View.GONE
                registerBtn.visibility = View.VISIBLE
                googleLoginBtn.visibility = View.VISIBLE
                authEmailEditView.visibility = View.VISIBLE
                authPasswordEditView.visibility = View.VISIBLE
                loginBtn.visibility = View.VISIBLE
                signBtn.visibility = View.GONE
            }
        } else if (mode === "signing") {
            binding.run {
                authMainTextView.text = ""
                logoutBtn.visibility = View.GONE
                registerBtn.visibility = View.GONE
                googleLoginBtn.visibility = View.GONE
                authEmailEditView.visibility = View.VISIBLE
                authPasswordEditView.visibility = View.VISIBLE
                loginBtn.visibility = View.GONE
                signBtn.visibility = View.VISIBLE
            }
        }
    }
}