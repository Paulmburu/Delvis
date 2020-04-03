package com.polotechnologies.delvis.ui.shop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.polotechnologies.delvis.R
import com.polotechnologies.delvis.databinding.FragmentShopBinding

/**
 * A simple [Fragment] subclass.
 */
class ShopFragment : Fragment() {

    private lateinit var mBinding: FragmentShopBinding
    private lateinit var selectedCategory: String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_shop, container, false)

        setToolBarDetails()
        return mBinding.root
    }

    private fun setToolBarDetails() {
        when(ShopFragmentArgs.fromBundle(arguments!!).category){
            "supermarket"->{
                mBinding.collapseToolbarShop.title = "Shopping"
                mBinding.imageIllustration.setImageResource(R.drawable.supermarket_hansonluu)
            }
            "pharmacy"->{
                mBinding.collapseToolbarShop.title = "Pharmacy"
                mBinding.imageIllustration.setImageResource(R.drawable.pharmacy_image)
            }
            "drinks"->{
                mBinding.collapseToolbarShop.title = "Liquor Store"
                mBinding.imageIllustration.setImageResource(R.drawable.liquor_by_chettersnap)
            }
            "groceries"->{
                mBinding.collapseToolbarShop.title = "Groceries"
                mBinding.imageIllustration.setImageResource(R.drawable.groceries_scottiewarman)
            }
            "gas"->{
                mBinding.collapseToolbarShop.title = "Gas"
                mBinding.imageIllustration.setImageResource(R.drawable.gas_cylinders)
            }
        }
    }


}
