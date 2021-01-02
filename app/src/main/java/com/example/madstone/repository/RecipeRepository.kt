package com.example.madstone.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.madstone.dao.RecipeDao
import com.example.madstone.database.LeftOverDatabase
import com.example.madstone.model.Recipe

class RecipeRepository (context: Context){

    private val recipeDao: RecipeDao

    init {
        val database = LeftOverDatabase.getDatabase(context)
        recipeDao = database!!.recipeDao()
    }

    fun getAllRecipes(): LiveData<List<Recipe>> {
        return recipeDao.getAllRecipes()
    }

}