package com.polotechnologies.delvis.ui.shop

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Simple ViewModel factory that provides the Hero and context to the ViewModel.
 */
class ShopViewModelFactory : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ShopViewModel::class.java)) {
            return ShopViewModel(
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
