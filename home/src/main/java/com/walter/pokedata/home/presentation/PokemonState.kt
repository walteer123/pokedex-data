package com.walter.pokedata.home.presentation

import androidx.paging.PagingData
import com.walter.pokedata.domain.entity.Pokemon

sealed class PokemonState {
    data class Data(val data: PagingData<Pokemon>) : PokemonState()
    data class Favorite(val message: String): PokemonState()
}
