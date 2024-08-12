package com.walter.pokedata.shared.data.datasource.local

import com.walter.pokedata.shared.factory.DatabaseServiceFactory
import com.walter.pokedata.sql.SyncDataEntity

class SyncDataLocalDataSource(private val databaseServiceFactory: DatabaseServiceFactory) {

    fun getSycDataMaxCount(): Long = databaseServiceFactory.create()
        .syncDataQueries.selectMaxCount()
        .executeAsOneOrNull()?.maxCount ?: 0

    fun insertMaxCount(maxCount: Long) =
        databaseServiceFactory
            .create()
            .syncDataQueries
            .insertMaxCount(SyncDataEntity(maxCount))
}