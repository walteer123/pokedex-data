package com.walter.pokedata.shared.data.repository

import com.walter.pokedata.shared.data.datasource.local.PokemonLocalDataSource
import com.walter.pokedata.shared.data.datasource.remote.PokemonRemoteDataSource
import com.walter.pokedata.shared.data.entity.toLocalEntity

class PokemonRepository(
    private val localDataSource: PokemonLocalDataSource,
    private val remoteDataSource: PokemonRemoteDataSource
) {
    suspend fun getPokemons() {
        var localResponse = localDataSource.getPokemons()
        if (localResponse.isEmpty()) {
           val items = remoteDataSource.getPokemons()
           localDataSource.insertPokemons(items.map { it.toLocalEntity() })
           localResponse = localDataSource.getPokemons()
        }
    }
}