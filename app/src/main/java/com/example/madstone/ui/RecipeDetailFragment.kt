package com.example.madstone.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.example.madstone.databinding.FragmentRecipeBinding
import com.example.madstone.viemodel.RecipeViewModel
import kotlinx.android.synthetic.main.fragment_recipe.view.*

class RecipeDetailFragment : Fragment(){

    private var _binding: FragmentRecipeBinding? = null
    private val binding get() = _binding!!

    private val recipeViewModel: RecipeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecipeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}