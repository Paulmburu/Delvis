package com.polotechnologies.delvis.ui.signUp

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
import com.google.firebase.firestore.FirebaseFirestore
import com.polotechnologies.delvis.R
import com.polotechnologies.delvis.databinding.FragmentSignUpBinding

/**
 * A [Fragment] that will be used for login purposes.
 */
class SignUpFragment : Fragment() {

    private lateinit var mBinding: FragmentSignUpBinding
    private lateinit var mViewModel: SignUpViewModel
    private lateinit var mAuth: FirebaseAuth
    private lateinit var firestore: FirebaseFirestore
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_up, container, false)
        mAuth = FirebaseAuth.getInstance()
        firestore = FirebaseFirestore.getInstance()

        val factory = SignUpViewModelFactory(mAuth, mBinding)
        mViewModel = ViewModelProvider(this, factory)[SignUpViewModel::class.java]

        setOnClickListeners()

        return mBinding.root
    }

    private fun setOnClickListeners() {
        mBinding.btnSignUp.setOnClickListener {
            if(mViewModel.isUserDetailsValid()){
                signUpUser()
            }

        }

        mBinding.btnLoginOption.setOnClickListener {
            findNavController().navigate(R.id.action_signUpFragment_to_loginFragment)
        }

    }

    private fun signUpUser() {
        mBinding.btnSignUp.isEnabled = false
        mAuth.createUserWithEmailAndPassword(mViewModel.user.value!!.user_email, mViewModel.user.value!!.user_password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(context, "Sign Up Successful", Toast.LENGTH_SHORT).show()
                    saveUserDetails()
                    findNavController().navigate(R.id.action_signUpFragment_to_locationSetUpFragment)
                }
            }.addOnFailureListener {exception ->
                Toast.makeText(context, "Failed to Sign Up: ${exception.localizedMessage}", Toast.LENGTH_SHORT).show()

            }
        }

    private fun saveUserDetails() {
        val user = mViewModel.user.value!!
        user.user_id=mAuth.currentUser!!.uid

        firestore.collection("users").document(mAuth.currentUser!!.uid)
            .set(user)
    }
}

