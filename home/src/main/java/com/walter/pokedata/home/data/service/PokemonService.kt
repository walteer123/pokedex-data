package com.walter.pokedata.home.data.service

import com.walter.pokedata.home.data.entity.PokemonListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonService {

    @GET("pokemon")
    suspend fun fetchPokemonList(
            @Query("limit") limit: Int = 20,
            @Query("offset") offset: Int = 0
    ): PokemonListResponse

}
