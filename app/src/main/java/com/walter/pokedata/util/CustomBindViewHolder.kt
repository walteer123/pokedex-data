package com.walter.pokedata.util

import androidx.databinding.ViewDataBinding

abstract class CustomBindViewHolder<in T>(binding: ViewDataBinding) : androidx.recyclerview.widget.RecyclerView.ViewHolder(binding.root) {
    abstract fun bind(data: T?)
}