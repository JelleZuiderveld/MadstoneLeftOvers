package com.example.madstone.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.madstone.model.ShoppingList

@Dao
interface ShoppingDao{

    @Query("SELECT * FROM shopping_table")
    fun getAllShopping(): LiveData<List<ShoppingList>>

    @Insert
    suspend fun addShopping(shoppingList: ShoppingList)

    @Delete
    suspend fun deleteShopping(shoppingList: ShoppingList)

    @Query("DELETE FROM shopping_table")
    suspend fun deleteAllShopping()
}