package com.example.madstone.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.madstone.dao.RecipeDao
import com.example.madstone.dao.ShoppingDao
import com.example.madstone.model.Recipe
import com.example.madstone.model.ShoppingList

@Database(entities = [ShoppingList::class, Recipe::class], version = 2, exportSchema = false)
abstract class LeftOverDatabase: RoomDatabase() {

    abstract fun shoppingDao(): ShoppingDao
    abstract fun recipeDao(): RecipeDao

    companion object {
        private const val DATABASE_NAME = "LEFTOVER_DATABASE"


        @Volatile
        private var databaseInstance: LeftOverDatabase? = null

        fun getDatabase(context: Context): LeftOverDatabase? {
            if (databaseInstance == null) {
                synchronized(LeftOverDatabase::class.java) {
                    if (databaseInstance == null) {
                        databaseInstance =
                            Room.databaseBuilder(
                                context.applicationContext,
                                LeftOverDatabase::class.java,
                                DATABASE_NAME
                            ).fallbackToDestructiveMigration().build()
                    }
                }
            }
            return databaseInstance
        }
    }
}