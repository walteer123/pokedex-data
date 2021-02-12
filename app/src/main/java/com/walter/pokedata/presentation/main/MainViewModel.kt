package com.walter.pokedata.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.walter.pokedata.data.repository.PokemonPagingSource
import com.walter.pokedata.domain.Pokemon
import com.walter.pokedata.domain.PokemonRepository
import com.walter.pokedata.domain.PokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject constructor(private val pokemonUseCase: PokemonUseCase): ViewModel() {

    private val _state = MutableLiveData<PokemonState>()
    val state : MutableLiveData<PokemonState> get() = _state

    val data = pokemonUseCase.getPokemonData().cachedIn(viewModelScope)


}