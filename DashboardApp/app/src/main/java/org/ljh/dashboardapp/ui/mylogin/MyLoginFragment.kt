package org.ljh.dashboardapp.ui.mylogin

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.ljh.dashboardapp.R
import org.ljh.dashboardapp.databinding.FragmentMyLoginBinding

class MyLoginFragment : Fragment() {

    companion object {
        fun newInstance() = MyLoginFragment()
    }

    private lateinit var viewModel: MyLoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding=FragmentMyLoginBinding.inflate(inflater,container,false)
        binding.button.setOnClickListener{
            binding.tv.setText(binding.et.text.toString())
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MyLoginViewModel::class.java)
        // TODO: Use the ViewModel
    }

}