package com.walter.pokedata.data.repository.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.walter.pokedata.data.service.PokemonService
import com.walter.pokedata.domain.entity.Pokemon
import javax.inject.Inject

class PokemonPagingSource @Inject constructor(
    private val pokemonService: PokemonService
) : PagingSource<Int, Pokemon>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Pokemon> {
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

    override fun getRefreshKey(state: PagingState<Int, Pokemon>): Int? {
        return state.anchorPosition
    }
}
