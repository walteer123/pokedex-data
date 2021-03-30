package com.walter.pokedata.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.addRepeatingJob
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.walter.pokedata.databinding.FragmentHomeBinding
import com.walter.pokedata.presentation.home.adapter.PokemonListAdapter
import com.walter.pokedata.presentation.home.adapter.PokemonLoadStateAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    val viewModel: HomeViewModel by viewModels()
    val pokemonAdapter by lazy {
        PokemonListAdapter(
            onItemClick = { findNavController().navigate(HomeFragmentDirections.navToDetails()) },
            onFavClick = { viewModel.interact(HomeFragmentInteraction.Favorite) }
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentHomeBinding.inflate(inflater, container,false)
        setRecycler(binding)
        setupLifecycleEvents()

        return binding.root
    }

    private fun setRecycler(binding: FragmentHomeBinding) {
        binding.pokemonRecycler.apply {
            adapter = pokemonAdapter
        }
    }

    private fun setupLifecycleEvents() {
        lifecycleScope.launch {
            pokemonAdapter.withLoadStateFooter(
                footer = PokemonLoadStateAdapter(pokemonAdapter::retry)
            )
            collectStates()
        }
    }

    private fun collectStates() {
        viewLifecycleOwner.addRepeatingJob(Lifecycle.State.STARTED) {
            viewModel.stateFlow.collectLatest { state ->
                when (state) {
                    is PokemonState.Data -> pokemonAdapter.submitData(state.data)
                    is PokemonState.Favorite -> Toast.makeText(this@HomeFragment.context, state.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}