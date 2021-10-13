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
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel
@Inject constructor(private val pokemonPagingSource: PokemonPagingSourceProvider): ViewModel() {

    private val _state = MutableLiveData<PokemonState>()
    val state : LiveData<PokemonState> get() = _state

    private val data: Flow<PagingData<Pokemon>> = Pager(PagingConfig(pageSize = 20, enablePlaceholders = false)){
        pokemonPagingSource.instance
    }.flow.cachedIn(viewModelScope)

    init {
        viewModelScope.launch {
            data.collect {
                _state.value = PokemonState.Data(it)
            }
        }
    }

    fun interact(interaction: HomeFragmentInteraction) {
        when(interaction) {
            is HomeFragmentInteraction.Refresh -> pokemonPagingSource.instance.invalidate()
            is HomeFragmentInteraction.Favorite -> _state.value =
                PokemonState.Favorite("Mensagem boba!")
        }
    }
}
