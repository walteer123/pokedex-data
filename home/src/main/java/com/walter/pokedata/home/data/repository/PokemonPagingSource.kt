package com.walter.pokedata.home.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.walter.pokedata.home.data.extensions.transform
import com.walter.pokedata.shared.data.service.PokemonService

class PokemonPagingSource(
    private val pokemonService: PokemonService
) : PagingSource<Int, com.walter.pokedata.home.domain.entity.Pokemon>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, com.walter.pokedata.home.domain.entity.Pokemon> {
        val offset = params.key ?: 0
        return try {
            val response = pokemonService.fetchPokemonList(limit = params.loadSize, offset = offset)

            LoadResult.Page(
                data = response.results.map { it.transform() },
                prevKey = null,
                nextKey = offset + params.loadSize
            )
        } catch (e: Exception) {
            LoadResult.Error(Throwable(e))
        }
    }

    override fun getRefreshKey(state: PagingState<Int, com.walter.pokedata.home.domain.entity.Pokemon>): Int? {
        return state.anchorPosition
    }
}
