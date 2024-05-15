package com.walter.pokedata.home.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.PagingData
import com.walter.pokedata.home.R
import com.walter.pokedata.home.databinding.FragmentHomeBinding
import com.walter.pokedata.home.domain.entity.Pokemon
import com.walter.pokedata.home.presentation.adapter.PokemonListAdapter
import com.walter.pokedata.home.presentation.adapter.PokemonLoadStateAdapter
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    val viewModel: HomeViewModel by viewModel()
    val pokemonAdapter by lazy {
        PokemonListAdapter(
            onItemClick = { findNavController().navigate(R.id.nav_to_details) },
            onFavClick = { viewModel.interact(HomeFragmentInteraction.Favorite) }
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        setRecycler(binding)
        setupLifecycleEvents()
        observeStates()

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
        }
    }

    private fun observeStates() {
        viewModel.state.observe(viewLifecycleOwner) {
            it?.let { state ->
                when (state) {
                    is PokemonState.Data -> updateItems(state.data)
                    is PokemonState.Favorite -> Toast.makeText(
                        this@HomeFragment.context,
                        state.message,
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }


    private fun updateItems(data: PagingData<Pokemon>) {
        lifecycleScope.launch {
            pokemonAdapter.submitData(data)
        }
    }
}