package com.walter.pokedata.presentation.main

sealed class MainState {
    object Loading: MainState()
    data class ConnectionData(val message: String): MainState()
}
