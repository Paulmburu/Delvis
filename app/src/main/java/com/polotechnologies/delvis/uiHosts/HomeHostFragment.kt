package com.polotechnologies.delvis.uiHosts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.polotechnologies.delvis.R
import com.polotechnologies.delvis.databinding.FragmentHomeHostBinding

/**
 * A simple [Fragment] subclass.
 */
class HomeHostFragment : Fragment() {

    private lateinit var mBinding:FragmentHomeHostBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_host, container, false)
        return mBinding.root
    }

}
