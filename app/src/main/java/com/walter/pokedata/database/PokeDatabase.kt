package com.walter.pokedata.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.walter.pokedata.data.dao.ConnectionStatusDao
import com.walter.pokedata.data.entity.local.ConnectionStatusEntity

@Database(
    entities = [ConnectionStatusEntity::class],
    version = 1
)
abstract class PokeDatabase : RoomDatabase() {
    abstract fun connectionStatusDao(): ConnectionStatusDao
}
