package com.walter.pokedata.data.entity.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "connection_status")
data class ConnectionStatusEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "wifi_state") val wifiState: String
)
