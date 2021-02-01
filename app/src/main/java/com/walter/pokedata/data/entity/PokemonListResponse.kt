package com.walter.pokedata.data.entity

import com.squareup.moshi.Json

data class PokemonListResponse<T> (
        @field:Json(name = "count") val count: Int,
        @field:Json(name = "next") val nextPage: String,
        @field:Json(name = "previous") val previousPage: String,
        @field:Json(name = "results") val results: List<T>
)
