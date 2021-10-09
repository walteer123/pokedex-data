package com.walter.pokedata.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.walter.pokedata.domain.entity.WifiState
import com.walter.pokedata.domain.usecase.ConnectionStatusUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@HiltViewModel
class MainViewModel @Inject
constructor(private val useCase: ConnectionStatusUseCase) : ViewModel() {

    val state: StateFlow<MainState> get() = _state
    private val _state: MutableStateFlow<MainState> = MutableStateFlow(MainState.Loading)

    init {
        viewModelScope.launch {
            useCase.getConnectionStatus().collectLatest {
                it?.let { connection ->
                    _state.value = when (connection.wifiState) {
                        WifiState.CONNECTED -> MainState.ConnectionData("Net conectada")
                        WifiState.DISCONNECTED -> MainState.ConnectionData("Caiu a net")
                    }
                }
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
