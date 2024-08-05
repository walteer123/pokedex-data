package com.walter.pokedata.shared.factory

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.walter.pokedata.sql.PokemonDatabase

actual class DriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(PokemonDatabase.Schema, "pokemon.db")
    }
}