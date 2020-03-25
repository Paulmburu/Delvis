package com.polotechnologies.delvis.ui.intros

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.polotechnologies.delvis.R
import com.polotechnologies.delvis.databinding.FragmentFirstIntroBinding

/**
 * A simple [Fragment] subclass.
 */
class FirstIntroFragment : Fragment() {

    private lateinit var mBinding: FragmentFirstIntroBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_first_intro, container, false)
        mBinding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_firstIntroFragment_to_secondIntroFragment)
        }
        return mBinding.root
    }

}
