package com.walter.pokedata.presentation.home

import androidx.lifecycle.*
import androidx.paging.cachedIn
import com.walter.pokedata.domain.PokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject constructor(private val pokemonUseCase: PokemonUseCase): ViewModel() {

    private val _state = MutableLiveData<PokemonState>()
    val state : MutableLiveData<PokemonState> get() = _state

    val data = pokemonUseCase.getPokemonData().cachedIn(viewModelScope)

}