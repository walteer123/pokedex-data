package com.walter.pokedata.presentation.main

import com.walter.pokedata.domain.Pokemon

sealed class PokemonState {
    data class Data(val items: List<Pokemon>) : PokemonState()
}
