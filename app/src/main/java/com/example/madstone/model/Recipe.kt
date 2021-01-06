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
        fun populateData(): ArrayList<Recipe> {
            return arrayListOf(
                Recipe("pasta","italianse pasta", "pasta, tomatensaus, gehakt", "this is how to prepare"),
                Recipe("hamburger", "hamburger", "hamburger, brooodjes, ketchup, sla", "bak hamburger paar minuten"),
                Recipe("boerenkool", "stamport", "aardappel, boerenkool, spek, worst", "how to prepare"),
                Recipe("noodles", "noodles met kip", "kip, noodles, wokgroenten","how to prepare")
            )
        }
    }
}