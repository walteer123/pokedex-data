package com.walter.pokedata.presentation.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.SpringForce
import androidx.fragment.app.Fragment
import com.walter.pokedata.databinding.FragmentPokemonDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokemonDetailsFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentPokemonDetailsBinding.inflate(inflater,container,false)

        /*val animator = SpringAnimation(binding.detailsName, DynamicAnimation.TRANSLATION_Y)
        val sf = SpringForce().apply {
            stiffness = SpringForce.STIFFNESS_LOW
            finalPosition = 1200F
            dampingRatio = SpringForce.DAMPING_RATIO_HIGH_BOUNCY
        }

        animator.spring = sf
        binding.detailsName.setOnClickListener {
            animator.start()
        }*/


        return binding.root
    }

}
