package com.polotechnologies.delvis.ui.login

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.polotechnologies.delvis.R
import com.polotechnologies.delvis.databinding.FragmentLoginBinding

/**
 * A [Fragment] that will be used for login purposes.
 */
class LoginFragment : Fragment() {

    private lateinit var mBinding:FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        setOnClickListeners()

        if(!isIntroDisplayed()){
            findNavController().navigate(R.id.action_loginFragment_to_introHostFragment)
        }

        return mBinding.root
    }

    private fun setOnClickListeners() {
        mBinding.btnLogin.setOnClickListener {
            Toast.makeText(context, "Logging in...", Toast.LENGTH_SHORT).show()
        }
        mBinding.btnSignUpOption.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
        }
    }

    private fun isIntroDisplayed(): Boolean {
        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return false
        val defaultValue = false

        return when(sharedPref.getBoolean(getString(R.string.shared_pref_intro_displayed), defaultValue)){
            true-> true
            else-> false
        }
    }

}
