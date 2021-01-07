package com.example.madstone.model

import android.media.Image
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.madstone.R


@Entity(tableName = "recipe_table")
data class Recipe(

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "image")
    val image : Int,

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
                Recipe("pasta", R.drawable.pasta ,"italianse pasta", "pasta, tomatensaus, gehakt", "this is how to prepare"),
                Recipe("hamburger", R.drawable.theultimatehamburger,"hamburger", "hamburger, brooodjes, ketchup, sla", "bak hamburger paar minuten"),
                Recipe("boerenkool", R.drawable.boerenkool , "stampot", "aardappel, boerenkool, spek, worst", "how to prepare"),
                Recipe("noodles", R.drawable.noodles ,"noodles met kip", "kip, noodles, wokgroenten","how to prepare")
            )
        }
    }
}