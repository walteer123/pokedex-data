package com.walter.pokedata.home.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.walter.pokedata.home.domain.entity.Pokemon
import com.walter.pokedata.home.domain.repository.PokemonPagingSourceProvider
import kotlinx.coroutines.flow.Flow

class HomeViewModel(private val pokemonPagingSource: PokemonPagingSourceProvider): ViewModel() {

    private val _state = MutableLiveData<PokemonState>()
    val state : LiveData<PokemonState> get() = _state

    val data: Flow<PagingData<Pokemon>> = Pager(PagingConfig(pageSize = 20, enablePlaceholders = false)){
        pokemonPagingSource.instance
    }.flow.cachedIn(viewModelScope)


    fun interact(interaction: HomeInteraction) {
        when(interaction) {
            is HomeInteraction.Refresh -> pokemonPagingSource.instance.invalidate()
            is HomeInteraction.Favorite -> _state.value =
                PokemonState.Favorite("Mensagem boba!")
        }
    }
}
