package com.walter.pokedata.presentation.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.walter.pokedata.data.repository.PokemonPagingSource
import com.walter.pokedata.domain.Pokemon
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject constructor(private val pokemonPagingSource: PokemonPagingSource): ViewModel() {

    private val _state = MutableLiveData<PokemonState>()
    val state : MutableLiveData<PokemonState> get() = _state

    val data: Flow<PagingData<Pokemon>> = Pager(PagingConfig(pageSize = 20, enablePlaceholders = false)){
        pokemonPagingSource
    }.flow.cachedIn(viewModelScope)

}
