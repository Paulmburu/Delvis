package com.polotechnologies.delvis.ui.location

import android.R.attr
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.widget.Autocomplete
import com.google.android.libraries.places.widget.AutocompleteActivity
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.polotechnologies.delvis.R
import com.polotechnologies.delvis.databinding.FragmentLocationSetUpBinding


/**
 * A [Fragment] used to setup the location of the signedUp user.
 */
class LocationSetUpFragment : Fragment() {

    private lateinit var mBinding: FragmentLocationSetUpBinding

    companion object {
        val AUTOCOMPLETE_REQUEST_CODE = 1
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_location_set_up, container, false)

        Places.initialize(context!!, getString(R.string.google_maps_key));

        mBinding.btnSetLocation.setOnClickListener {
            displayLocationDialog()
        }
        return mBinding.root
    }

    private fun displayLocationDialog() {
        val pictureDialogItems = arrayOf("Current Location", "Add an Address")
        val locationSelectionDialog = MaterialAlertDialogBuilder(
            context,
            R.style.MaterialAlertDialog_MaterialComponents_Title_Icon
        ).let { dialogBuilder ->
            dialogBuilder.setTitle("Select Delivery Address")
            dialogBuilder.setItems(pictureDialogItems) { _, which ->
                when (which) {
                    0 -> Toast.makeText(context, "Current Location", Toast.LENGTH_SHORT).show()
                    1 -> {
                        findNavController().navigate(R.id.action_locationSetUpFragment_to_mapFragment)
                    }
                }
            }

        }
        locationSelectionDialog.show()
    }

    private fun loadAddressPicker() {
        val fields =
            listOf(Place.Field.ID, Place.Field.NAME)

        val intent =
            Autocomplete.IntentBuilder(AutocompleteActivityMode.OVERLAY, fields).build(context!!)
        startActivityForResult(intent, AUTOCOMPLETE_REQUEST_CODE)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == AUTOCOMPLETE_REQUEST_CODE) {
            when (resultCode) {
                Activity.RESULT_OK -> {
                    val place = Autocomplete.getPlaceFromIntent(data!!)
                }
                AutocompleteActivity.RESULT_ERROR -> {
                    val status = Autocomplete.getStatusFromIntent(data!!)
                    Toast.makeText(context, status.statusMessage, Toast.LENGTH_SHORT).show()

                }
                AutocompleteActivity.RESULT_CANCELED -> {
                    Toast.makeText(context, "Cancelled by user", Toast.LENGTH_SHORT).show()
                }

            }

        }

    }
}
