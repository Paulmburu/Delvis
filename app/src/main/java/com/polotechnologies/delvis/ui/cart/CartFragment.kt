package com.polotechnologies.delvis.ui.cart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.polotechnologies.delvis.R
import com.polotechnologies.delvis.databinding.FragmentCartBinding

/**
 * A simple [Fragment] subclass.
 */
class CartFragment : Fragment() {

    private lateinit var mBinding: FragmentCartBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_cart, container, false)


        return mBinding.root
    }

}
