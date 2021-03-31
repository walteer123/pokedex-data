package com.walter.pokedata.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.walter.pokedata.domain.Pokemon
import com.walter.pokedata.domain.PokemonRepository
import com.walter.pokedata.util.onError
import com.walter.pokedata.util.onSuccess

import javax.inject.Inject

class PokemonPagingSource @Inject constructor(
    private val repository: PokemonRepository
): PagingSource<Int, Pokemon>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Pokemon> {
        val offset = params.key ?: 0
        return try {
            lateinit var result: LoadResult<Int, Pokemon>
            repository.fetchPokemonList(params.loadSize, offset)
                .onSuccess { pokemonList ->
                    result = LoadResult.Page(
                        data = pokemonList,
                        prevKey = null,
                        nextKey = pokemonList.offsetOrNull(offset + params.loadSize)
                    )

                }
                .onError {
                    result = LoadResult.Error(
                        throwable = Throwable(it)
                    )
                }
             result
        } catch (e: Exception) {
            LoadResult.Error(Throwable(e))
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Pokemon>): Int? {
        return state.anchorPosition
    }

    private fun List<Pokemon>.offsetOrNull(offset:Int) : Int? =
        if (this.isEmpty())
            null
        else
            offset + 1

}