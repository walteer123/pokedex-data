package com.walter.pokedata.shared.data.datasource.remote


import androidx.paging.ExperimentalPagingApi
import app.cash.paging.LoadType
import app.cash.paging.PagingState
import app.cash.paging.RemoteMediator
import app.cash.paging.RemoteMediatorInitializeAction
import app.cash.paging.RemoteMediatorMediatorResult
import app.cash.paging.RemoteMediatorMediatorResultSuccess
import com.walter.pokedata.shared.data.service.PokemonService
import com.walter.pokedata.shared.domain.entity.Pokemon
import com.walter.pokedata.shared.factory.DatabaseServiceFactory

@OptIn(ExperimentalPagingApi::class)
class PokemonRemoteMediator(
    private val pokemonService: PokemonService,
    databaseServiceFactory: DatabaseServiceFactory
): RemoteMediator<Int, Pokemon>() {
    private val db = databaseServiceFactory.create()

    override suspend fun initialize(): RemoteMediatorInitializeAction {
      val syncTotalItems = db.syncDataQueries.selectMaxCount().executeAsOneOrNull()?.maxCount?.toInt() ?: 0
      val localItemsTotal = db.pokemonQueries.selectAll().executeAsList().count()
      return if (localItemsTotal == syncTotalItems){
          RemoteMediatorInitializeAction.SKIP_INITIAL_REFRESH
      } else {
          RemoteMediatorInitializeAction.LAUNCH_INITIAL_REFRESH
      }
    }
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, Pokemon>
    ): RemoteMediatorMediatorResult {

        val loadKey = when (loadType) {
            LoadType.REFRESH -> null
            LoadType.PREPEND -> {
                return RemoteMediatorMediatorResultSuccess(true)
            }
            LoadType.APPEND -> {
                val lastItem =  state.lastItemOrNull()
                if (lastItem == null) {
                   return  RemoteMediatorMediatorResultSuccess(true)
                }
                lastItem.name
            }
        }

            // Suspending network load via Retrofit. This doesn't need to be
            // wrapped in a withContext(Dispatcher.IO) { ... } block since
            // Retrofit's Coroutine CallAdapter dispatches on a worker
            // thread.
            val response = pokemonService.fetchPokemonList(
              limit = 50, offset = 0
            )

        //    database.withTransaction {
        //      if (loadType == LoadType.REFRESH) {
        //        userDao.deleteByQuery(query)
        //      }
        //
        //      // Insert new users into database, which invalidates the
        //      // current PagingData, allowing Paging to present the updates
        //      // in the DB.
        //      userDao.insertAll(response.users)
        //    }
        //
        //    MediatorResult.Success(
        //      endOfPaginationReached = response.nextKey == null
        //    )


        //return try {
        //    // The network load method takes an optional after=<user.id>
        //    // parameter. For every page after the first, pass the last user
        //    // ID to let it continue from where it left off. For REFRESH,
        //    // pass null to load the first page.
        //    val loadKey = when (loadType) {
        //      LoadType.REFRESH -> null
        //      // In this example, you never need to prepend, since REFRESH
        //      // will always load the first page in the list. Immediately
        //      // return, reporting end of pagination.
        //      LoadType.PREPEND ->
        //        return MediatorResult.Success(endOfPaginationReached = true)
        //      LoadType.APPEND -> {
        //        val lastItem = state.lastItemOrNull()
        //
        //        // You must explicitly check if the last item is null when
        //        // appending, since passing null to networkService is only
        //        // valid for initial load. If lastItem is null it means no
        //        // items were loaded after the initial REFRESH and there are
        //        // no more items to load.
        //        if (lastItem == null) {
        //          return MediatorResult.Success(
        //            endOfPaginationReached = true
        //          )
        //        }
        //
        //        lastItem.id
        //      }
        //    }
        //
        //    // Suspending network load via Retrofit. This doesn't need to be
        //    // wrapped in a withContext(Dispatcher.IO) { ... } block since
        //    // Retrofit's Coroutine CallAdapter dispatches on a worker
        //    // thread.
        //    val response = networkService.searchUsers(
        //      query = query, after = loadKey
        //    )
        //
        //    database.withTransaction {
        //      if (loadType == LoadType.REFRESH) {
        //        userDao.deleteByQuery(query)
        //      }
        //
        //      // Insert new users into database, which invalidates the
        //      // current PagingData, allowing Paging to present the updates
        //      // in the DB.
        //      userDao.insertAll(response.users)
        //    }
        //
        //    MediatorResult.Success(
        //      endOfPaginationReached = response.nextKey == null
        //    )
        //  } catch (e: IOException) {
        //    MediatorResult.Error(e)
        //  } catch (e: HttpException) {
        //    MediatorResult.Error(e)
        //  }
        TODO("Finish mediator")
    }

}