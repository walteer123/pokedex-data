package com.walter.pokedata.data.repository.local

import com.walter.pokedata.data.dao.ConnectionStatusDao
import com.walter.pokedata.data.entity.local.ConnectionStatusEntity
import com.walter.pokedata.data.entity.local.toConnectionStatusEntity
import com.walter.pokedata.domain.entity.ConnectionStatus
import com.walter.pokedata.domain.entity.WifiState
import com.walter.pokedata.domain.repository.ConnectionStatusRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.flow.transform

class ConnectionStatusRepositoryImpl @Inject constructor(
    private val connectionDao: ConnectionStatusDao
) : ConnectionStatusRepository {
    override suspend fun updateWifiState(wifiState: WifiState) =
        connectionDao.upsert(ConnectionStatusEntity(1, wifiState.value))


    override suspend fun getCurrentConnectionStatus(): WifiState {
        val entity = connectionDao.getCurrentConnectionStatus()
        val teste = entity?.transform()?.wifiState ?: WifiState.CONNECTED
        return teste
    }


    override fun observeConnectionStatus(): Flow<ConnectionStatus> =
        connectionDao.observeConnectionStatusChange().mapLatest {
            it?.transform()
        }
}
