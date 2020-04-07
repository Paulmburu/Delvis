package com.polotechnologies.delvis.ui.shopProductsCategory

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController

import com.polotechnologies.delvis.R
import com.polotechnologies.delvis.databinding.FragmentProductCategoryBinding

/**
 * A simple [Fragment] to display selected products
 * available in the shop.
 */
class ProductCategoryFragment : Fragment(){

    private lateinit var mBinding: FragmentProductCategoryBinding
    private lateinit var mViewModel: ProductCategoryViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_product_category, container, false)

        val factory = ProductCategoryViewModelFactory()
        mViewModel = ViewModelProvider(this,factory)[ProductCategoryViewModel::class.java]

        setDisplayDetails()
        setObservers()
        return mBinding.root
    }

    private fun setDisplayDetails() {
        when(ProductCategoryFragmentArgs.fromBundle(arguments!!).selectedProductCategory){
            "Liquor"->{
                mBinding.toolbarProductCategory.title = "Liquor Store"
                mBinding.recyclerProductCategory.adapter = ProductCategoryRecyclerAdapter(mViewModel.liquor,
                    ProductCategoryRecyclerAdapter.OnClickListener{productCategory->
                        mViewModel.displaySelectedProductCategory(productCategory)
                    })
            }
        }
    }

    private fun setObservers() {
        mViewModel.selectedProductCategory.observe(viewLifecycleOwner, Observer {productCategory->
            val action = ProductCategoryFragmentDirections
                .actionProductCategoryFragmentToProductListFragment(productCategory.category_name)
            activity!!.findNavController(R.id.nav_host_main).navigate(action)
        })
    }

}
