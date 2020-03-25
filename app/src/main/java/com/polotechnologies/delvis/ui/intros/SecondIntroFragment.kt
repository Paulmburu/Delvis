package com.polotechnologies.delvis.ui.intros

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.polotechnologies.delvis.R
import com.polotechnologies.delvis.databinding.FragmentSecondIntroBinding

/**
 * A simple [Fragment] subclass.
 */
class SecondIntroFragment : Fragment() {

    private lateinit var mBinding:FragmentSecondIntroBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_second_intro, container, false)
        mBinding.btnFinish.setOnClickListener {
            activity?.findNavController(R.id.nav_host_main)?.navigate(R.id.action_introHostFragment_to_loginFragment)
        }
        return mBinding.root
    }

}
