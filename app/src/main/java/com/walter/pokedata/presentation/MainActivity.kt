package com.walter.pokedata.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.walter.pokedata.R
import dagger.hilt.android.AndroidEntryPoint
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       lifecycleScope.launch {
           viewModel.state.collect { state ->
               when(state) {
                   is PokemonState.Opened -> viewModel.interact(PokemonInteraction.Fetch)
               }
           }
       }

    }
}
