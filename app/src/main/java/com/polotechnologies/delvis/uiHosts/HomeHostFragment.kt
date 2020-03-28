package com.polotechnologies.delvis.uiHosts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.firebase.auth.FirebaseAuth

import com.polotechnologies.delvis.R
import com.polotechnologies.delvis.databinding.FragmentHomeHostBinding

/**
 * A simple [Fragment] subclass.
 */
class HomeHostFragment : Fragment(), Toolbar.OnMenuItemClickListener {

    private lateinit var mBinding:FragmentHomeHostBinding
    private lateinit var mAuth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_host, container, false)
        mBinding.toolbarHome.setOnMenuItemClickListener(this)

        mAuth = FirebaseAuth.getInstance()
        setUpBottomNav()
        return mBinding.root
    }

    private fun setUpBottomNav() {
        val navController = childFragmentManager.findFragmentById(R.id.nav_host_home)
        mBinding.bottomNavHome.setupWithNavController(navController = navController!!.findNavController())
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        if(item!!.itemId == R.id.action_sign_out){
            signOut()
        }
        return true
    }

    private fun signOut() {
        mAuth.signOut()
        Toast.makeText(context, "Signed Out Successfully", Toast.LENGTH_SHORT).show()
        activity!!.findNavController(R.id.nav_host_main).navigate(R.id.action_homeHostFragment_to_loginFragment)
    }
}
