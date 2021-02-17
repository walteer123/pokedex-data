package com.walter.pokedata.presentation.home

sealed class HomeFragmentInteraction {
    object Fetch : HomeFragmentInteraction()
    object Refresh: HomeFragmentInteraction()
}
