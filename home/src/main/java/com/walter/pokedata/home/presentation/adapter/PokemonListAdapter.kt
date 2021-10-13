package com.walter.pokedata.home.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import coil.load
import coil.transform.CircleCropTransformation
import com.walter.pokedata.home.databinding.PokemonListItemLayoutBinding
import com.walter.pokedata.home.domain.entity.Pokemon
import com.walter.pokedata.home.presentation.utils.CustomBindViewHolder

class PokemonListAdapter(val onItemClick: () -> Unit, val onFavClick: () -> Unit): PagingDataAdapter<Pokemon, CustomBindViewHolder<Pokemon>>(
    diffUtil
) {

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

    class PokemonViewHolder(private val binding: PokemonListItemLayoutBinding, val onItemClick: () -> Unit, val onFavClick: () -> Unit) : CustomBindViewHolder<Pokemon>(binding) {
        override fun bind(data: Pokemon?) {
            data?.let {
                binding.pokemonItemImage.load(it.imageUrl){
                    crossfade(true)
                    transformations(CircleCropTransformation())
                }
                binding.pokemonItemName.text = it.name
                binding.pokemonTemContainer.setOnClickListener {
                    onItemClick.invoke()
                }
                binding.pokemonFavorite.setOnClickListener {
                    onFavClick.invoke()
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomBindViewHolder<Pokemon> {
        return PokemonViewHolder(PokemonListItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false), onItemClick, onFavClick)
    }

    override fun onBindViewHolder(holder: CustomBindViewHolder<Pokemon>, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }


}