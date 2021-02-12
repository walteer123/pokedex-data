package com.walter.pokedata.presentation.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.walter.pokedata.R
import com.walter.pokedata.databinding.PokemonListItemLayoutBinding
import com.walter.pokedata.domain.Pokemon
import com.walter.pokedata.util.CustomBindViewHolder

class PokemonListAdapter(): ListAdapter<Pokemon, CustomBindViewHolder<Pokemon>>(diffUtil) {

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Pokemon>() {
            override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
               return oldItem.name == newItem.name
            }

        }
    }

    class PokemonViewHolder(private val binding: PokemonListItemLayoutBinding) : CustomBindViewHolder<Pokemon>(binding) {
        override fun bind(data: Pokemon?) {
            data?.let {
                binding.pokemonItemImage.load(it.imageUrl){
                    crossfade(true)
                    transformations(CircleCropTransformation())
                }
                binding.pokemonItemName.text = it.name
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomBindViewHolder<Pokemon> {
        return PokemonViewHolder(PokemonListItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: CustomBindViewHolder<Pokemon>, position: Int) {
        currentList?.getOrNull(position)?.let { holder.bind(getItem(position)) }
    }


}