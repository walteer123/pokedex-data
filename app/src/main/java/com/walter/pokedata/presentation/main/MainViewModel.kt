package com.walter.pokedata.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.walter.pokedata.domain.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject constructor(private val pokemonRepository: PokemonRepository): ViewModel() {

    private val _state = MutableLiveData<PokemonState>()
    val state : MutableLiveData<PokemonState> get() = _state

    init {
        fetchPokemons()
    }

    private fun fetchPokemons(){
        viewModelScope.launch {
           val items = pokemonRepository.fetchPokemonList(20,0)
            _state.value = PokemonState.Data(items = items )
        }
    }





}