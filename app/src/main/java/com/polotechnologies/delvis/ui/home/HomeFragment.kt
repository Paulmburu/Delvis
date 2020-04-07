package com.polotechnologies.delvis.ui.home

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.polotechnologies.delvis.R
import com.polotechnologies.delvis.databinding.FragmentHomeBinding
import com.polotechnologies.delvis.uiHosts.HomeHostFragmentDirections

/**
 * A [Fragment] to display Available Products Option.
 */
class HomeFragment : Fragment() {

    private lateinit var mBinding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_home, container, false)

        if(!isLocationSet()){
            activity!!.findNavController(R.id.nav_host_main)
                .navigate(R.id.action_homeHostFragment_to_locationSetUpFragment)
        }

        setClickListeners()

        return mBinding.root
    }

    private fun setClickListeners() {
        mBinding.cardShopping.setOnClickListener {
            navigateToShop("supermarket")
        }
        mBinding.cardPharmacy.setOnClickListener {
            navigateToShop("pharmacy")
        }
        mBinding.cardDrinks.setOnClickListener {
            navigateToShop("drinks")
        }
        mBinding.cardGroceries.setOnClickListener {
            navigateToShop("groceries")
        }

        mBinding.cardGas.setOnClickListener {
            navigateToShop("gas")
        }
    }

    private fun navigateToShop(category: String) {
        val action = HomeHostFragmentDirections.actionHomeHostFragmentToShopFragment(category)
        activity!!.findNavController(R.id.nav_host_main).navigate(action)
    }


    private fun isLocationSet(): Boolean {
        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return false
        val defaultValue = false

        return when(sharedPref.getBoolean(getString(R.string.shared_pref_location_set), defaultValue)){
            true-> true
            else-> false
        }
    }
}
