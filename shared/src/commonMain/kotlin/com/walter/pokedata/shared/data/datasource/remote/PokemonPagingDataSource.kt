package com.walter.pokedata.shared.data.datasource.remote

import app.cash.paging.PagingSource
import app.cash.paging.PagingSourceLoadResult
import app.cash.paging.PagingSourceLoadResultError
import app.cash.paging.PagingSourceLoadResultPage
import app.cash.paging.PagingState
import com.walter.pokedata.shared.data.entity.toLocalEntity
import com.walter.pokedata.shared.data.mappers.transform
import com.walter.pokedata.shared.data.service.PokemonService
import com.walter.pokedata.shared.domain.entity.Pokemon

class PokemonPagingDataSource(
    private val pokemonService: PokemonService
): PagingSource<Int, Pokemon>() {

    override fun getRefreshKey(state: PagingState<Int, Pokemon>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): PagingSourceLoadResult<Int, Pokemon> {
        val offset = params.key ?: 0
        return try {
            val response = pokemonService.fetchPokemonList(limit = params.loadSize, offset = offset)

            PagingSourceLoadResultPage(
                data = response.results.map { it.toLocalEntity().transform() },
                prevKey = null,
                nextKey = offset + params.loadSize
            )

        } catch (e: Exception) {
            PagingSourceLoadResultError(Throwable(e))
        }
    }
}