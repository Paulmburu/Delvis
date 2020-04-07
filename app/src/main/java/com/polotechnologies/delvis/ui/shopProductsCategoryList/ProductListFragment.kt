package com.polotechnologies.delvis.ui.shopProductsCategoryList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.polotechnologies.delvis.R
import com.polotechnologies.delvis.databinding.FragmentProductListBinding

/**
 * A simple [Fragment] subclass.
 */
class ProductListFragment : Fragment() {

    private lateinit var mBinding: FragmentProductListBinding
    private lateinit var mViewModel: ProductListViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_product_list, container,false)

        val factory = ProductListViewModelFactory()
        mViewModel = ViewModelProvider(this,factory)[ProductListViewModel::class.java]

        return mBinding.root
    }


}
