package com.walter.pokedata.shared.factory

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.walter.pokedata.sql.PokemonDatabase

actual class DriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(PokemonDatabase.Schema, context, "pokemon.db")
    }
}

actual class DatabaseServiceFactoryImpl(private val driverFactory: DriverFactory) : DatabaseServiceFactory {
    actual override fun create(): PokemonDatabase {
        return PokemonDatabase(driverFactory.createDriver())
    }
}