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
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val viewModel: MainViewModel by viewModels()
    val pokemonAdapter by lazy { PokemonListAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        setRecycler(binding)
        observeListData()

    }

    private fun setRecycler(binding: ActivityMainBinding) {
        binding.pokemonRecycler.apply {
            adapter = pokemonAdapter
        }
    }

    private fun observeListData() {
        lifecycleScope.launch {
            viewModel.data.collectLatest {
                pokemonAdapter.submitData(it)
            }
        }
    }

}
