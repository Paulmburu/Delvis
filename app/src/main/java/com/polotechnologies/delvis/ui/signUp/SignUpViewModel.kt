package com.polotechnologies.delvis.ui.signUp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.polotechnologies.delvis.dataModels.User
import com.polotechnologies.delvis.databinding.FragmentSignUpBinding

class SignUpViewModel(val mAuth: FirebaseAuth, val mBinding: FragmentSignUpBinding) : ViewModel() {

    private val _isDetailsValid = MutableLiveData<Boolean>()
    val isDetailsValid: LiveData<Boolean>
        get() = _isDetailsValid

    private val _user = MutableLiveData<User>()
    val user: LiveData<User>
        get() = _user


    fun isUserDetailsValid(): Boolean {
        _isDetailsValid.value = false

        if (mBinding.etSignUpEmail.text!!.isEmpty()) {
            mBinding.etSignUpEmail.error = "Email Required"
        }
        if (mBinding.etSignUpPassword.text!!.isEmpty()) {
            mBinding.etSignUpPassword.error = "Password Required"
        }
        if (mBinding.etSignUpPhoneNumber.text!!.isEmpty()) {
            mBinding.etSignUpPhoneNumber.error = "Phone Number Required"
        }

        if (mBinding.etSignUpEmail.text!!.isNotEmpty() &&
            mBinding.etSignUpPassword.text!!.isNotEmpty() &&
            mBinding.etSignUpPhoneNumber.text!!.isNotEmpty()
        ) {
            val user = User(
                "",
                mBinding.etSignUpEmail.text!!.toString(),
                mBinding.etSignUpPassword.text!!.toString(),
                mBinding.etSignUpPhoneNumber.text!!.toString(),
                ""
            )
            _user.value = user
            _isDetailsValid.value = true
        }

        return isDetailsValid.value!!

    }

}