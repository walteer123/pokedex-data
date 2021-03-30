package com.walter.pokedata.presentation.home

import androidx.paging.PagingData
import com.walter.pokedata.domain.Pokemon

sealed class PokemonState {
    data class Data(val data: PagingData<Pokemon>) : PokemonState()
    data class Favorite(val message: String): PokemonState()
}
