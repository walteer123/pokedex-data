package com.walter.pokedata.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.walter.pokedata.domain.Pokemon
import com.walter.pokedata.domain.PokemonRepository

class PokemonPagingSource(
    private val repository: PokemonRepository
): PagingSource<Int, Pokemon>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Pokemon> {
        val offset = params.key ?: 0
        return try {
            val data = repository.fetchPokemonList(params.loadSize, offset)
            LoadResult.Page(
                data = data,
                prevKey = null,
                nextKey = offset + params.loadSize + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(Throwable(e))
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Pokemon>): Int? {
        TODO("Not yet implemented")
    }

}