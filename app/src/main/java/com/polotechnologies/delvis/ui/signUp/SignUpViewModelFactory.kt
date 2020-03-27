package com.polotechnologies.delvis.ui.signUp

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.polotechnologies.delvis.databinding.FragmentSignUpBinding

class SignUpViewModelFactory (private val mAuth: FirebaseAuth,
                                         private val mBinding: FragmentSignUpBinding) : ViewModelProvider.Factory {
        @Suppress("unchecked_cast")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(SignUpViewModel::class.java)) {
                return SignUpViewModel(
                    mAuth,
                    mBinding
                ) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
}