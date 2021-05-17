package com.walter.pokedata.data.entity.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.walter.pokedata.domain.entity.ConnectionStatus
import com.walter.pokedata.domain.entity.WifiState

@Entity(tableName = "connection_status")
data class ConnectionStatusEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "wifi_state") val wifiState: String?
) {
    fun transform() = ConnectionStatus(
        id = id,
        wifiState = WifiState.values().find { it.value == wifiState } ?: WifiState.CONNECTED
    )
}

fun ConnectionStatus.toConnectionStatusEntity() = ConnectionStatusEntity(
    id = id,
    wifiState = wifiState.value
)