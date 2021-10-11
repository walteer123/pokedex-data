package com.walter.pokedata.data.repository.remote.provider

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.walter.pokedata.domain.entity.Pokemon
import com.walter.pokedata.domain.repository.PokemonRepository
import com.walter.pokedata.util.onError
import com.walter.pokedata.util.onSuccess
import javax.inject.Inject

class PokemonPagingSource @Inject constructor(
    private val repository: PokemonRepository
) : PagingSource<Int, Pokemon>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Pokemon> {
        val offset = params.key ?: 0
        return try {
            lateinit var result: LoadResult<Int, Pokemon>
            repository.fetchPokemonList(params.loadSize, offset)
                .onSuccess { response ->
                    val items = response.results.map { it.transform() }
                    result = LoadResult.Page(
                        data = items,
                        prevKey = null,
                        nextKey = offset + params.loadSize
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
}
