package com.walter.pokedata.home.data.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokemonListResponse (
        @field:Json(name = "count") val count: Int,
        @field:Json(name = "next") val nextPage: String?,
        @field:Json(name = "previous") val previousPage: String?,
        @field:Json(name = "results") val results: List<PokemonRemote>
)
