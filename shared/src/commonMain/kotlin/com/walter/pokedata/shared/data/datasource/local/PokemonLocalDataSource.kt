package com.walter.pokedata.shared.data.datasource.local

import com.walter.pokedata.shared.factory.DatabaseServiceFactory
import com.walter.pokedata.sql.PokemonEntity

class PokemonLocalDataSource(private val databaseServiceFactory: DatabaseServiceFactory) {

    fun getPokemons(): List<PokemonEntity> {
        return databaseServiceFactory.create()
            .pokemonQueries
            .selectAll()
            .executeAsList()
    }

    fun insertPokemons(pokemons: List<PokemonEntity>) {
        with(databaseServiceFactory.create()) {
            pokemonQueries.transaction {
                pokemons.forEach {
                    pokemonQueries.insertPokemonObject(it)
                }
            }
        }
    }
}