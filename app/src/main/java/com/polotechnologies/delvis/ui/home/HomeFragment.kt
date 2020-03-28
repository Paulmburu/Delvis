package com.polotechnologies.delvis.ui.home

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getColor
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.polotechnologies.delvis.R
import com.polotechnologies.delvis.databinding.FragmentHomeBinding

/**
 * A [Fragment] to display home.
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
            activity!!.findNavController(R.id.nav_host_main).navigate(R.id.action_homeHostFragment_to_locationSetUpFragment)
        }

        setClickListeners()

        return mBinding.root
    }

    private fun setClickListeners() {
        mBinding.cardShopping.setOnClickListener {cardView->
            setCardAttributes(cardView)

        }
        mBinding.cardPharmacy.setOnClickListener {cardView->
            setCardAttributes(cardView)

        }
        mBinding.cardDrinks.setOnClickListener {cardView->
            setCardAttributes(cardView)

        }
        mBinding.cardGroceries.setOnClickListener {cardView->
            setCardAttributes(cardView)

        }
    }

    private fun setCardAttributes(cardView: View) {
        cardView.elevation = 10F
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
