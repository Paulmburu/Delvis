package com.polotechnologies.delvis.ui.location.googleMapFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.polotechnologies.delvis.R
import com.polotechnologies.delvis.databinding.FragmentMapBinding


/**
 * A [Fragment] to host google maps.
 */
class MapFragment : Fragment(), OnMapReadyCallback {

    private lateinit var mBinding: FragmentMapBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_map, container, false)

        val mapFragment = childFragmentManager.findFragmentById(R.id.map_user_location) as SupportMapFragment
        mapFragment.getMapAsync(this)

        return mBinding.root
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        val sydney = LatLng(-33.852, 151.211)
        googleMap!!.addMarker(
            MarkerOptions().position(sydney)
                .title("Marker in Sydney")
        )
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }

}
