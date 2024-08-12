package com.walter.pokedata.home.presentation

sealed class HomeInteraction {
    object Refresh: HomeInteraction()
    object Favorite: HomeInteraction()
}
