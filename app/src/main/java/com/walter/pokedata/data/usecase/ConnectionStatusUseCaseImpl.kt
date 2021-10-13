package com.walter.pokedata.data.usecase

import com.walter.pokedata.domain.entity.ConnectionStatus
import com.walter.pokedata.domain.entity.WifiState
import com.walter.pokedata.domain.repository.ConnectionStatusRepository
import com.walter.pokedata.domain.usecase.ConnectionStatusUseCase
import com.walter.pokedata.network.SafeRequest
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class ConnectionStatusUseCaseImpl @Inject constructor(
    private val repository: ConnectionStatusRepository,
    private val safeRequest: SafeRequest
) : ConnectionStatusUseCase {

    override suspend fun getConnectionStatus(): Flow<ConnectionStatus?> =
        repository.observeConnectionStatus()

    override suspend fun updateConnectionStatus(wifiState: WifiState) = safeRequest {
        if (repository.getCurrentConnectionStatus() != wifiState) {
            repository.updateWifiState(wifiState)
        }
    }
}
