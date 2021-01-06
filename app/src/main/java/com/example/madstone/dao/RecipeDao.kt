package com.example.madstone.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.madstone.model.Recipe
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDao{

    @Insert
    fun insert(recipe: ArrayList<Recipe>)

    @Query("SELECT * FROM recipe_table")
    fun getAllRecipes(): LiveData<List<Recipe>>

    @Query("SELECT * FROM recipe_table WHERE ingredients LIKE :query")
    fun getRecipeIngredient(query: String): LiveData<List<Recipe>>

    @Insert
    suspend fun addRecipe(recipe: Recipe)

    @Query("DELETE FROM recipe_table")
    suspend fun deleteRecipes()


}