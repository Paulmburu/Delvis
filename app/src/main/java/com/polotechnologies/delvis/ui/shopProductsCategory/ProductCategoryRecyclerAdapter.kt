package com.polotechnologies.delvis.ui.shopProductsCategory

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.polotechnologies.delvis.dataModels.ProductCategory
import com.polotechnologies.delvis.databinding.ItemProductCategoryBinding

class ProductCategoryRecyclerAdapter(private val productCategories: List<ProductCategory>, private val onClickListener: OnClickListener):
    RecyclerView.Adapter<ProductCategoryRecyclerAdapter.ProductCategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductCategoryViewHolder {
        return ProductCategoryViewHolder.from(parent)
    }

    override fun getItemCount(): Int  = productCategories.size

    override fun onBindViewHolder(holder: ProductCategoryViewHolder, position: Int) {
        val productCategory = productCategories[position]
        holder.itemView.setOnClickListener {
            onClickListener.onClick(productCategory)
        }
        holder.bind(productCategory)
    }

    class OnClickListener(val clickListener : (productCategory: ProductCategory) -> Unit){
        fun onClick(productCategory: ProductCategory) = clickListener(productCategory)
    }


    class ProductCategoryViewHolder(val binding: ItemProductCategoryBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(productCategory: ProductCategory){
            binding.productCategory = productCategory
            binding.executePendingBindings()
        }

        companion object{
            fun from (parent: ViewGroup) : ProductCategoryViewHolder{

                val inflater = LayoutInflater.from(parent.context)
                val binding = ItemProductCategoryBinding.inflate(inflater, parent, false)
                return ProductCategoryViewHolder(binding)
            }
        }

    }
}