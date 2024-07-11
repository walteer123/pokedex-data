package com.walter.pokedata.home.presentation

sealed class HomeInteraction {
    data object Refresh: HomeInteraction()
    data object Favorite: HomeInteraction()
}
