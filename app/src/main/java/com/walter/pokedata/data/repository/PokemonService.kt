package com.walter.pokedata.data.repository

import com.walter.pokedata.data.entity.PokemonListResponse
import com.walter.pokedata.data.entity.PokemonRemote
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonService {

    @GET("pokemon")
    suspend fun fetchPokemonList(
            @Query("limit") limit: Int = 20,
            @Query("offset") offset: Int = 0
    ): PokemonListResponse

}
