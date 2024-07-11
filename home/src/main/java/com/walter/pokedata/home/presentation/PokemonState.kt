package com.walter.pokedata.home.presentation

sealed class PokemonState {
    data class Favorite(val message: String): PokemonState()
}
