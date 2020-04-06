package com.polotechnologies.delvis.ui.shop

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.polotechnologies.delvis.R
import com.polotechnologies.delvis.dataModels.Shop

class ShopViewModel : ViewModel() {

    //selected Shop Category
    private val _selectedShopCategory = MutableLiveData<Shop>()
    val selectedShopCategory : LiveData<Shop>
        get () = _selectedShopCategory


    val drinkShop = listOf(
        Shop("Liquor", R.drawable.illustration_liqour_glass),
        Shop("Beer", R.drawable.illustration_beer),
        Shop("Wine", R.drawable.ilustration_wine_bottle),
        Shop("Soft Drinks", R.drawable.illustration_soft_drinks)
    )

    fun displaySelectedCategory(shop: Shop){
        _selectedShopCategory.value = shop
    }

    fun displaySelectedCategoryComplete(){
        _selectedShopCategory.value = null
    }
}