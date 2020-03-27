package com.polotechnologies.delvis.ui.login

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.polotechnologies.delvis.R
import com.polotechnologies.delvis.databinding.FragmentLoginBinding

/**
 * A [Fragment] that will be used for login purposes.
 */
class LoginFragment : Fragment() {

    private lateinit var mBinding:FragmentLoginBinding
    private lateinit var mViewModel: LoginViewModel
    private lateinit var mAuth : FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        mAuth = FirebaseAuth.getInstance()

        val factory = LoginViewModelFactory(mAuth, mBinding)
        mViewModel = ViewModelProvider(this, factory)[LoginViewModel::class.java]

        setOnClickListeners()

        if(!isIntroDisplayed()){
            findNavController().navigate(R.id.action_loginFragment_to_introHostFragment)
        }

        return mBinding.root
    }

    private fun setOnClickListeners() {
        mBinding.btnLogin.setOnClickListener {
            if(mViewModel.isUserDetailsValid()){
                loginUser()
            }
        }
        mBinding.btnSignUpOption.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
        }
    }

    private fun loginUser() {
        mBinding.btnLogin.isEnabled = false
        mAuth.signInWithEmailAndPassword(mViewModel.user.value!!.user_email, mViewModel.user.value!!.user_password)
            .addOnCompleteListener{task->
                if(task.isSuccessful){
                    findNavController().navigate(R.id.action_loginFragment_to_homeHostFragment)
                }

            }.addOnFailureListener {exception->
                Toast.makeText(context, "Login Failed: ${exception.localizedMessage}", Toast.LENGTH_SHORT).show()
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
