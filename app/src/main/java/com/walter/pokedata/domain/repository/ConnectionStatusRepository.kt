package com.walter.pokedata.domain.repository

import com.walter.pokedata.domain.entity.ConnectionStatus
import com.walter.pokedata.domain.entity.WifiState
import kotlinx.coroutines.flow.Flow

interface ConnectionStatusRepository {

    suspend fun updateWifiState(wifiState: WifiState)

    suspend fun getCurrentConnectionStatus(): WifiState

    fun observeConnectionStatus(): Flow<ConnectionStatus?>

}
