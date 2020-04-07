package com.polotechnologies.delvis.ui.shop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.polotechnologies.delvis.R
import com.polotechnologies.delvis.databinding.FragmentShopBinding

/**
 * A simple [Fragment] subclass.
 */
class ShopFragment : Fragment() {

    private lateinit var mBinding: FragmentShopBinding
    private lateinit var mViewModel: ShopViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_shop, container, false)

        val factory = ShopViewModelFactory()
        mViewModel = ViewModelProvider(this, factory)[ShopViewModel::class.java]

        setDisplayDetails()
        setObservers()
        return mBinding.root
    }

    private fun setDisplayDetails() {
        when (ShopFragmentArgs.fromBundle(arguments!!).category) {
            "supermarket" -> {
                displayShopDetails(
                    R.drawable.illustration_supermarket_neoonbrand,
                    "Shopping",
                    "Tuskeys Supermarket"
                )
            }
            "pharmacy" -> {
                displayShopDetails(
                    R.drawable.illustration_pharmacy_image,
                    "Pharmacy",
                    "Kiokos Wines and Spirit"
                )
            }
            "drinks" -> {
                displayShopDetails(
                    R.drawable.illustration_liquor_by_chettersnap,
                    "Liquor Store",
                    "Kiokos Wines and Spirit"
                )
                mBinding.recyclerShop.adapter = ShopRecyclerAdapter(mViewModel.drinkShop,
                    ShopRecyclerAdapter.OnClickListener { shop ->
                        mViewModel.displaySelectedCategory(shop)
                    })
            }
            "groceries" -> {
                mBinding.collapseToolbarShop.title = "Groceries"
                displayShopDetails(
                    R.drawable.illustration_groceries_scottiewarman,
                    "Groceries",
                    "Kwa Mama Jere Groceries"
                )
            }
            "gas" -> {
                mBinding.collapseToolbarShop.title = "Gas"
                displayShopDetails(
                    R.drawable.illustration_gas_cylinders,
                    "Gas",
                    "Gas Mart"
                )
            }
        }
    }

    private fun setObservers() {
        mViewModel.selectedShopCategory.observe(viewLifecycleOwner, Observer { shop ->
            val action =
                ShopFragmentDirections.actionShopFragmentToProductCategoryFragment(shop.shop_name)
            activity!!.findNavController(R.id.nav_host_main).navigate(action)
        })
    }

    private fun displayShopDetails(imageDrawable: Int, shopCategory: String, shopName: String) {
        mBinding.collapseToolbarShop.title = shopCategory
        mBinding.textShopName.text = shopName

        Glide.with(this)
            .load(imageDrawable)
            .into(mBinding.imageIllustration)
            .clearOnDetach()

    }


}
