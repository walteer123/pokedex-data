package com.walter.pokedata.presentation.home

sealed class HomeFragmentInteraction {
    object Refresh: HomeFragmentInteraction()
    object Favorite: HomeFragmentInteraction()
}
