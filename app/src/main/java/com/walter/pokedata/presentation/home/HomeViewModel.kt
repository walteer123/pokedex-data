package com.walter.pokedata.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.walter.pokedata.data.repository.PokemonPagingSource
import com.walter.pokedata.data.repository.PokemonPagingSourceProvider
import com.walter.pokedata.domain.Pokemon
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject constructor(private val pokemonPagingSource: PokemonPagingSourceProvider): ViewModel() {

    private val _stateFlow = MutableStateFlow<PokemonState>(PokemonState.Data(PagingData.empty()))
    val stateFlow : StateFlow<PokemonState> get() = _stateFlow

    private val data: Flow<PagingData<Pokemon>> = Pager(PagingConfig(pageSize = 20, enablePlaceholders = false)){
        pokemonPagingSource.instance
    }.flow.cachedIn(viewModelScope)

    init {
        viewModelScope.launch {
            data.collect {
                _stateFlow.value = PokemonState.Data(it)
            }
        }
    }

    fun interact(interaction: HomeFragmentInteraction) {
        when(interaction) {
            is HomeFragmentInteraction.Refresh ->{ pokemonPagingSource.instance.invalidate() }
        }
    }

}
