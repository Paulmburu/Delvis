package com.polotechnologies.delvis.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.polotechnologies.delvis.databinding.FragmentLoginBinding

class LoginViewModelFactory (private val mAuth: FirebaseAuth,
                             private val mBinding: FragmentLoginBinding) : ViewModelProvider.Factory {
        @Suppress("unchecked_cast")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
                return LoginViewModel(
                    mAuth,
                    mBinding
                ) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
}