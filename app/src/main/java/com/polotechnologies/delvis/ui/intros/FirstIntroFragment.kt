package com.polotechnologies.delvis.ui.intros

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.polotechnologies.delvis.R
import com.polotechnologies.delvis.databinding.FragmentFirstIntroBinding

/**
 * A [Fragment] to introduce the user to the app.
 */
class FirstIntroFragment : Fragment() {

    private lateinit var mBinding: FragmentFirstIntroBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_first_intro, container, false)
        mBinding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_firstIntroFragment_to_secondIntroFragment)
        }

        setAppIntroDisplayedToSharedPreference()
        return mBinding.root
    }

    private fun setAppIntroDisplayedToSharedPreference() {
        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return
        with (sharedPref.edit()) {
            putBoolean(getString(R.string.shared_pref_intro_displayed), true)
            commit()
        }
    }

}
