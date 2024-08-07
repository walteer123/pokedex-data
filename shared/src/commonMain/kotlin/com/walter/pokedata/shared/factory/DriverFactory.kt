package com.walter.pokedata.shared.factory

import app.cash.sqldelight.db.SqlDriver
import com.walter.pokedata.sql.PokemonDatabase

expect class DriverFactory {
     fun createDriver(): SqlDriver
}

expect class DatabaseServiceFactoryImpl: DatabaseServiceFactory {
    override fun create(): PokemonDatabase
}

fun createDatabase(driverFactory: DriverFactory): PokemonDatabase {
    val driver = driverFactory.createDriver()
    val database = PokemonDatabase(driver)
    return database
}
