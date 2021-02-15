package com.walter.pokedata.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.walter.pokedata.databinding.FragmentHomeBinding
import com.walter.pokedata.presentation.home.adapter.PokemonListAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    val viewModel: HomeViewModel by viewModels()
    val pokemonAdapter by lazy {
        PokemonListAdapter { findNavController().navigate(HomeFragmentDirections.navToDetails()) }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentHomeBinding.inflate(inflater, container,false)
        setRecycler(binding)
        observeListData()

        return binding.root
    }

    private fun setRecycler(binding: FragmentHomeBinding) {
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