package com.walter.pokedata.home.presentation.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.walter.pokedata.home.databinding.FragmentPokemonDetailsBinding

class PokemonDetailsFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentPokemonDetailsBinding.inflate(inflater,container,false)
        return binding.root
    }

}
