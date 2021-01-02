package com.example.madstone.viemodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.madstone.model.Recipe
import com.example.madstone.model.ShoppingList
import com.example.madstone.repository.RecipeRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RecipeViewModel (application: Application): AndroidViewModel(application){

    private val scope = CoroutineScope(Dispatchers.IO)
    private val recipeRepository: RecipeRepository = RecipeRepository(application.applicationContext)
    val recipeData: LiveData<List<Recipe>> = recipeRepository.getAllRecipes()


}