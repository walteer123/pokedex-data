package com.walter.pokedata.data.dao

import android.database.sqlite.SQLiteConstraintException
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.walter.pokedata.data.entity.local.ConnectionStatusEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ConnectionStatusDao {
    @Query("SELECT * FROM connection_status WHERE id = 1")
    fun getCurrentConnectionStatus(): ConnectionStatusEntity?

    @Query("SELECT * FROM connection_status WHERE id = 1")
    fun observeConnectionStatusChange(): Flow<ConnectionStatusEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entity: ConnectionStatusEntity?)

    @Update(onConflict = OnConflictStrategy.ABORT)
    fun update(entity: ConnectionStatusEntity?)

    @Transaction
    fun upsert(entity: ConnectionStatusEntity?) {
        try {
            insert(entity)
        } catch (exception: SQLiteConstraintException) {
            update(entity)
        }
    }
}
