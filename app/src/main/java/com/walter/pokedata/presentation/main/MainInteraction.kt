package com.walter.pokedata.presentation.main

import com.walter.pokedata.domain.entity.WifiState

sealed class MainInteraction {
    data class UpdateConnectionStatus(val wifiState: WifiState) : MainInteraction()
}
