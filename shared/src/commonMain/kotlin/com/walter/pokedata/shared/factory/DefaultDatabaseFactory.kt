package com.walter.pokedata.shared.factory

import com.walter.pokedata.sql.PokemonDatabase

class DefaultDatabaseFactory(private val driverFactory: DriverFactory): DatabaseServiceFactory {
    override fun create(): PokemonDatabase {
        return PokemonDatabase(driverFactory.createDriver())
    }
}