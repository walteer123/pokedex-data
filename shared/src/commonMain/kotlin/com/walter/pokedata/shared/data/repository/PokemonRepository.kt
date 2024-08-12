package com.walter.pokedata.shared.data.repository

import com.walter.pokedata.shared.data.datasource.local.PokemonLocalDataSource
import com.walter.pokedata.shared.data.datasource.local.SyncDataLocalDataSource
import com.walter.pokedata.shared.data.datasource.remote.PokemonRemoteDataSource
import com.walter.pokedata.shared.data.entity.toLocalEntity
import com.walter.pokedata.shared.data.mappers.transform
import com.walter.pokedata.shared.domain.entity.Pokemon

private const val LIMIT = 50
class PokemonRepository(
    private val localDataSource: PokemonLocalDataSource,
    private val syncDataLocalDataSource: SyncDataLocalDataSource,
    private val remoteDataSource: PokemonRemoteDataSource
) {
    suspend fun getPokemons(): List<Pokemon> {
        val localResponse = localDataSource.getPokemons()

        if (localResponse.isEmpty()) {
            val response = remoteDataSource.getPokemonResponse()
            syncDataLocalDataSource.insertMaxCount(response.count.toLong())
        }

       if (localResponse.size.toLong() <= syncDataLocalDataSource.getSycDataMaxCount()) {
           val response = remoteDataSource.getPokemonResponse(
               limit = LIMIT,
               offset = localResponse.size
           )
           if (response.nextPage != null) {
               localDataSource.insertPokemons(response.results.map { it.toLocalEntity() })
           }
       }
        return localResponse.map { it.transform() }
    }
}