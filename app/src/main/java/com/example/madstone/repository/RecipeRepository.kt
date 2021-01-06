package com.example.madstone.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.madstone.dao.RecipeDao
import com.example.madstone.database.LeftOverDatabase
import com.example.madstone.model.Recipe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn

class RecipeRepository (context: Context){

    private val recipeDao: RecipeDao

    init {
        val database = LeftOverDatabase.getDatabase(context)
        recipeDao = database!!.recipeDao()
    }

    fun getAllRecipes(): LiveData<List<Recipe>> {
        return recipeDao.getAllRecipes()
    }

    suspend fun addRecipe(recipe: Recipe) {
        return recipeDao.addRecipe(recipe)
    }

    suspend fun insert(recipe: ArrayList<Recipe>){
        return recipeDao.insert(recipe)
    }

    suspend fun deleteAllRecipe(){
        return recipeDao.deleteRecipes()
    }

}