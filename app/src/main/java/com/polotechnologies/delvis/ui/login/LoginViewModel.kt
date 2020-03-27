package com.polotechnologies.delvis.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.polotechnologies.delvis.dataModels.User
import com.polotechnologies.delvis.databinding.FragmentLoginBinding

class LoginViewModel(val mAuth: FirebaseAuth, val mBinding: FragmentLoginBinding) : ViewModel() {

    private val _isDetailsValid = MutableLiveData<Boolean>()
    private val isDetailsValid: LiveData<Boolean>
        get() = _isDetailsValid

    private val _user = MutableLiveData<User>()
    val user: LiveData<User>
        get() = _user


    fun isUserDetailsValid(): Boolean {
        _isDetailsValid.value = false

        if (mBinding.etLoginEmail.text!!.isEmpty()) {
            mBinding.etLoginEmail.error = "Email Required"
        }
        if (mBinding.etLoginPassword.text!!.isEmpty()) {
            mBinding.etLoginPassword.error = "Password Required"
        }

        if (mBinding.etLoginEmail.text!!.isNotEmpty() &&
            mBinding.etLoginPassword.text!!.isNotEmpty()
        ) {
            val user = User(
                "",
                mBinding.etLoginEmail.text!!.toString(),
                mBinding.etLoginPassword.text!!.toString(),
                "",
                ""
            )
            _user.value = user
            _isDetailsValid.value = true
        }

        return isDetailsValid.value!!

    }

}