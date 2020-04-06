package com.polotechnologies.delvis.ui.shop

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.polotechnologies.delvis.dataModels.Shop
import com.polotechnologies.delvis.databinding.ItemShopBinding

class ShopRecyclerAdapter(private val shopList : List<Shop>, private val onClickListener: OnClickListener)
    : RecyclerView.Adapter<ShopRecyclerAdapter.ShopViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopViewHolder {
        return ShopViewHolder.from(parent)
    }

    override fun getItemCount(): Int = shopList.size

    override fun onBindViewHolder(holder: ShopViewHolder, position: Int) {
        val shop  = shopList[position]
        holder.itemView.setOnClickListener{
            onClickListener.onClick(shop)
        }
        holder.bind(shop)
    }

    class OnClickListener(val clickListener : (shop: Shop) -> Unit){
        fun onClick(shop: Shop) = clickListener(shop)
    }


    class ShopViewHolder(val binding: ItemShopBinding)  : RecyclerView.ViewHolder(binding.root){

        fun bind(shop: Shop) {
            binding.shop = shop
            binding.executePendingBindings()

        }
        companion object{
            fun from(parent: ViewGroup): ShopViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemShopBinding.inflate(layoutInflater, parent, false)
                return ShopViewHolder(binding)
            }
        }
    }
}