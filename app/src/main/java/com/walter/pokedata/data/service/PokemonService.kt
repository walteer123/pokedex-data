package com.walter.pokedata.data.service

import com.walter.pokedata.data.entity.remote.PokemonListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonService {

    @GET("pokemon")
    suspend fun fetchPokemonList(
            @Query("limit") limit: Int = 20,
            @Query("offset") offset: Int = 0
    ): PokemonListResponse

}
