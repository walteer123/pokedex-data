package com.walter.pokedata.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.walter.pokedata.R
import dagger.hilt.android.AndroidEntryPoint
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.walter.pokedata.databinding.ActivityMainBinding
import com.walter.pokedata.presentation.main.adapter.PokemonListAdapter
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val viewModel: MainViewModel by viewModels()
    val pokemonAdapter by lazy { PokemonListAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        binding.pokemonRecycler.apply {
            adapter = pokemonAdapter
        }
        observeState()

    }

    private fun observeState() {
        viewModel.state.observe(this) { state ->
            state?.let {
                when (state) {
                    is PokemonState.Data -> {
                        pokemonAdapter.submitList(state.items)
                    }
                }
            }

        }
    }
}
