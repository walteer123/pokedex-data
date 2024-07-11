package com.walter.pokedata.home.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import org.koin.androidx.compose.koinViewModel

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun HomeScreen(viewModel: HomeViewModel = koinViewModel()){

    val coroutineScope = rememberCoroutineScope()

    val state = viewModel.state.observeAsState()
    when (val result = state.value) {
        is PokemonState.Favorite -> result.message
        else -> Unit
    }

   val data = viewModel.data.collectAsLazyPagingItems()
    LazyColumn {
        if (data.loadState.refresh  == LoadState.Loading){
            item { 
                Text(text = "Carregando parcero")
            }
        }

        items(count = data.itemCount) { index ->
            data[index]?.let {
                PokemonItem(pokemon = it) {
                    viewModel.interact(HomeInteraction.Favorite)
                }
            }
        }

        if (data.loadState.append == LoadState.Loading) {
            item {
                CircularProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally)
                )
            }
        }

    }
}