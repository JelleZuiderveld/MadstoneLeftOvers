package com.example.madstone.viemodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.madstone.model.Recipe

import com.example.madstone.repository.RecipeRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch

class RecipeViewModel (application: Application): AndroidViewModel(application){

    private val scope = CoroutineScope(Dispatchers.IO)
    private val recipeRepository: RecipeRepository = RecipeRepository(application.applicationContext)
    val recipeData: LiveData<List<Recipe>> = recipeRepository.getAllRecipes()


    fun addRecipe(recipe: Recipe){
        scope.launch {
            recipeRepository.addRecipe(recipe)
        }
    }

    fun insert(recipe: ArrayList<Recipe>){
        scope.launch {
            recipeRepository.insert(recipe)
        }
    }

    fun deleteAllRecipes(){
        scope.launch {
            recipeRepository.deleteAllRecipe()
        }
    }


}