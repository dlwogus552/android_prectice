package org.ljh.databaseapp02

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.ljh.databaseapp02.databinding.ActivityMain2Binding
import java.nio.charset.Charset

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnWrite.setOnClickListener{
            var outFs=openFileOutput("test.txt", Context.MODE_PRIVATE)
            var str=binding.editText3.text.toString()
            outFs.write(str.toByteArray())
            outFs.close()
        }
        binding.btnRead.setOnClickListener{
            try{
                var inFs=openFileInput("text.txt")
                var txt=ByteArray(inFs.available())
                inFs.read(txt)
                inFs.close()
                var str=txt.toString(Charset.defaultCharset())
                binding.textFileResult.text=str
            }catch (e:Exception){
                binding.textFileResult.text="파일없음"
                e.printStackTrace()
            }
        }
    }
}