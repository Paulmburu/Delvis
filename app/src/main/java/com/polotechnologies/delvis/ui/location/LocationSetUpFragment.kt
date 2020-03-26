package com.polotechnologies.delvis.ui.location

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import com.google.android.material.dialog.MaterialAlertDialogBuilder

import com.polotechnologies.delvis.R
import com.polotechnologies.delvis.databinding.FragmentLocationSetUpBinding
import com.polotechnologies.delvis.databinding.FragmentLoginBinding

/**
 * A [Fragment] used to setup the location of the signedUp user.
 */
class LocationSetUpFragment : Fragment() {

    private lateinit var mBinding: FragmentLocationSetUpBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_location_set_up, container, false)
        mBinding.btnSetLocation.setOnClickListener {
            displayLocationDialog()
        }
        return mBinding.root
    }

    private fun displayLocationDialog() {
        val pictureDialogItems = arrayOf("Current Location", "Add an Address")
        val locationSelectionDialog = MaterialAlertDialogBuilder(context,
            R.style.MaterialAlertDialog_MaterialComponents_Title_Icon).let { dialogBuilder ->
            dialogBuilder.setTitle("Select Delivery Address")
            dialogBuilder.setItems(pictureDialogItems) { _, which ->
                when (which) {
                    0 -> Toast.makeText(context, "Current Location", Toast.LENGTH_SHORT).show()
                    1 -> Toast.makeText(context, "Add an Address", Toast.LENGTH_SHORT).show()
                }
            }

        }
        locationSelectionDialog.show()
    }


}
