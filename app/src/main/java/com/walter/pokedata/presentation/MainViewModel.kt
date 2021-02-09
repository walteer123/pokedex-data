package com.walter.pokedata.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.walter.pokedata.domain.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject constructor(private val pokemonRepository: PokemonRepository): ViewModel() {

    private val _state = MutableStateFlow(PokemonState.Opened)
    val state : StateFlow<PokemonState> get() = _state

    fun interact(interaction: PokemonInteraction) {
        when(interaction) {
            is PokemonInteraction.Fetch -> fetchPokemons()
        }
    }


    private fun fetchPokemons(){
        viewModelScope.launch {
            pokemonRepository.fetchPokemonList(20,0)
        }
    }





}