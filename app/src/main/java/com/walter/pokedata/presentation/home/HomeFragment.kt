package com.walter.pokedata.presentation.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import com.walter.pokedata.R
import com.walter.pokedata.databinding.FragmentHomeBinding
import com.walter.pokedata.presentation.home.adapter.PokemonListAdapter
import com.walter.pokedata.presentation.home.adapter.PokemonLoadStateAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    val viewModel: HomeViewModel by viewModels()
    val pokemonAdapter by lazy {
        PokemonListAdapter {
            findNavController().navigate(HomeFragmentDirections.navToDetails())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentHomeBinding.inflate(inflater, container,false)
        setRecycler(binding)
        observeListData(binding)
        binding.homeMotionLayout.setTransitionListener(object: MotionLayout.TransitionListener{
            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
                Log.d("statusss","inicio")
            }

            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {
                Log.d("statusss","change")

            }

            override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
                Log.d("statusss","Cabo")
            }

            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {
                Log.d("statusss","trigger")
            }

        })
        return binding.root
    }

    private fun setRecycler(binding: FragmentHomeBinding) {
        binding.pokemonRecycler.apply {
            adapter = pokemonAdapter
        }
    }

    private fun observeListData(binding: FragmentHomeBinding) {
        lifecycleScope.launch {
            pokemonAdapter.withLoadStateFooter(
                footer = PokemonLoadStateAdapter(pokemonAdapter::retry)
            )
            viewModel.data.distinctUntilChanged().collectLatest {
                pokemonAdapter.submitData(lifecycle,it)
            }
        }
    }
}