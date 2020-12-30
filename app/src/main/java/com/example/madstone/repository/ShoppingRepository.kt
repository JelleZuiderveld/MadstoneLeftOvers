package com.example.madstone.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.madstone.dao.ShoppingDao
import com.example.madstone.database.LeftOverDatabase
import com.example.madstone.model.ShoppingList

class ShoppingRepository (context: Context){

    private val shoppingDao: ShoppingDao

    init {
        val database = LeftOverDatabase.getDatabase(context)
        shoppingDao = database!!.shoppingDao()
    }

    fun getAllShopping(): LiveData<List<ShoppingList>>{
        return shoppingDao.getAllShopping()
    }

    suspend fun addShopping(shoppingList: ShoppingList) {
        return shoppingDao.addShopping(shoppingList)
    }

    suspend fun deleteAllShopping(){
        return shoppingDao.deleteAllShopping()
    }

    suspend fun deleteShopping(shoppingList: ShoppingList){
        return shoppingDao.deleteShopping(shoppingList)
    }

}