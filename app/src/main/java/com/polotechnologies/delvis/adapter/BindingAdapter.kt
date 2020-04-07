package com.polotechnologies.delvis.adapter

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.polotechnologies.delvis.dataModels.ProductCategory
import com.polotechnologies.delvis.dataModels.Shop


@BindingAdapter("imageResource")
fun bind(imageView : AppCompatImageView, imageResource: Int){
    imageResource.let{
        Glide.with(imageView.context)
            .load(imageResource)
            .into(imageView)
            .clearOnDetach()
    }
}

@BindingAdapter("imageProduct")
fun bind(imageView : AppCompatImageView, imageUrl: String){
    imageUrl.let{
        Glide.with(imageView.context)
            .load(imageUrl)
            .into(imageView)
            .clearOnDetach()
    }
}