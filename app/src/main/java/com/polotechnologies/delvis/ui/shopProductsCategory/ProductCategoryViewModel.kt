package com.polotechnologies.delvis.ui.shopProductsCategory

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.polotechnologies.delvis.R
import com.polotechnologies.delvis.dataModels.ProductCategory

class ProductCategoryViewModel : ViewModel() {

    //selected Shop Category
    private val _selectedProductCategory = MutableLiveData<ProductCategory>()
    val selectedProductCategory : LiveData<ProductCategory>
        get () = _selectedProductCategory


    val liquor = listOf(
        ProductCategory("whiskey", R.drawable.whiskey_jameson_1000ml, R.drawable.whiskey_jack_daniels_1000ml,R.drawable.whiskey_johnnie_walker_double_black_1000ml),
        ProductCategory("brandy", R.drawable.brandy_kwv_brandy_10yrs_750ml, R.drawable.vodka_smirnoff_vodka_red_750ml,R.drawable.gin_gordons_gin_1000ml),
        ProductCategory("vodka",  R.drawable.vodka_ketel_one_vodka_750ml,R.drawable.vodka_smirnoff_vodka_red_750ml, R.drawable.vodka_ciroc_vodka_1000ml),
        ProductCategory("tequila", R.drawable.tequila_don_julio_tequila_1942_750ml, R.drawable.tequila_don_julio_tequila_blanco_750ml,R.drawable.tequila_don_julio_tequila_reposado_750ml),
        ProductCategory("gin", R.drawable.gin_gordons_gin_1000ml, R.drawable.gin_hendricks_gin_1000ml,R.drawable.whiskey_johnnie_walker_double_black_1000ml)

    )

    fun displaySelectedProductCategory(productCategory : ProductCategory){
        _selectedProductCategory.value = productCategory
    }

    fun displaySelectedProductCategoryComplete(){
        _selectedProductCategory.value = null
    }
}