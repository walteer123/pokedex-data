package com.walter.pokedata.presentation.main

sealed class MainState {
    data class Data(val message: String): MainState()
}
