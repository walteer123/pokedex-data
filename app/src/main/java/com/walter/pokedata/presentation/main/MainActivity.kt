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
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        observeState()

    }

    private fun observeState() {
        viewModel.state.observe(this) { state ->
            state?.let {
                when (state) {
                    is PokemonState.Data -> {}
                }
            }

        }
    }
}
