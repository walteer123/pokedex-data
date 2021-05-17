package com.walter.pokedata.domain.usecase

import com.walter.pokedata.domain.entity.ConnectionStatus
import com.walter.pokedata.domain.entity.WifiState
import com.walter.pokedata.util.Status
import kotlinx.coroutines.flow.Flow

interface ConnectionStatusUseCase {
    suspend fun getConnectionStatus(): Flow<ConnectionStatus>

    suspend fun updateConnectionStatus(wifiState: WifiState): Status<Unit>
}
