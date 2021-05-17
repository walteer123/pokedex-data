package com.walter.pokedata.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.walter.pokedata.domain.entity.WifiState
import com.walter.pokedata.domain.usecase.ConnectionStatusUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@HiltViewModel
class MainViewModel @Inject constructor(private val useCase: ConnectionStatusUseCase) :
    ViewModel() {
    init {
        viewModelScope.launch {
            useCase.getConnectionStatus().collect {
                TODO("Collect Connection flow from db and emit connection Message ")
            }
        }
    }
    fun interact(interaction: MainInteraction) {
        when (interaction) {
            is MainInteraction.UpdateConnectionStatus -> updateConnectionStatus(interaction.wifiState)
        }
    }

    private fun updateConnectionStatus(wifiState: WifiState) {
        viewModelScope.launch {
            useCase.updateConnectionStatus(wifiState)
        }
    }
}
