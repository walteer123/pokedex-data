package com.walter.pokedata.home.presentation

sealed class HomeFragmentInteraction {
    object Refresh: HomeFragmentInteraction()
    object Favorite: HomeFragmentInteraction()
}
