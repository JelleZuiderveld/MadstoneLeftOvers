package com.example.madstone.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "recipe_table")
data class Recipe(

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "description")
    val description: String,

    @ColumnInfo(name = "ingredients")
    val ingredients: String,

    @ColumnInfo(name = "prepare")
    val prepare: String,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Long? = null
){
    companion object{
        fun populateData(): Array<Recipe> {
            return arrayOf<Recipe>(
                Recipe("pasta","italianse pasta", "pasta, tomatensaus, 300gram gehakt", "this is how to prepare")
            )
        }
    }
}