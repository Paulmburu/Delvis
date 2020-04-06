package com.polotechnologies.delvis.ui.shopProductsCategory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Simple ViewModel factory for ProductCategory
 */
class ProductCategoryViewModelFactory : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductCategoryViewModel::class.java)) {
            return ProductCategoryViewModel(
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
