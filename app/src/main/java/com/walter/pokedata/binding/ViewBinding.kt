package com.walter.pokedata.binding

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object ViewBinding {

    @BindingAdapter("circleImageUrl")
    fun setCircleImageUrl(view: ImageView, url: String) {
        Glide
            .with(view.context)
            .load(url)
            .circleCrop()
            .into(view)
    }


}