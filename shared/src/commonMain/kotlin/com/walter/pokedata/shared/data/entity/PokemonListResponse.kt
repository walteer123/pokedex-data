package com.walter.pokedata.shared.data.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonListResponse (
        @SerialName("count") val count: Int,
        @SerialName("next") val nextPage: String?,
        @SerialName("previous") val previousPage: String?,
        @SerialName("results") val results: List<PokemonRemote>
)
