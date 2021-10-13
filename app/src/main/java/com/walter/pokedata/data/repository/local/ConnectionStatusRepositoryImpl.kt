package com.walter.pokedata.data.repository.local

import com.walter.pokedata.data.dao.ConnectionStatusDao
import com.walter.pokedata.data.entity.local.ConnectionStatusEntity
import com.walter.pokedata.domain.entity.ConnectionStatus
import com.walter.pokedata.domain.entity.WifiState
import com.walter.pokedata.domain.repository.ConnectionStatusRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.mapLatest

class ConnectionStatusRepositoryImpl @Inject constructor(
    private val connectionDao: ConnectionStatusDao
) : ConnectionStatusRepository {
    override suspend fun updateWifiState(wifiState: WifiState) =
        connectionDao.upsert(ConnectionStatusEntity(1, wifiState.value))

    override suspend fun getCurrentConnectionStatus(): WifiState = connectionDao
        .getCurrentConnectionStatus()?.transform()?.wifiState ?: WifiState.CONNECTED

    override fun observeConnectionStatus(): Flow<ConnectionStatus> =
        connectionDao.observeConnectionStatusChange()?.mapLatest {
            it?.transform()
        } ?: emptyFlow()
}
