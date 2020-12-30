package com.example.madstone.viemodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.madstone.model.ShoppingList
import com.example.madstone.repository.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(application: Application): AndroidViewModel(application){

    private val scope = CoroutineScope(Dispatchers.IO)
    private val shoppingRepository: ShoppingRepository = ShoppingRepository(application.applicationContext)
    val shoppingData: LiveData<List<ShoppingList>> = shoppingRepository.getAllShopping()

    fun addShopping(shoppingList: ShoppingList){
        scope.launch {
            shoppingRepository.addShopping(shoppingList)
        }
    }

    fun deleteShopping(shoppingList: ShoppingList){
        scope.launch {
            shoppingRepository.deleteShopping(shoppingList)
        }
    }

    fun deleteAllShopping(){
        scope.launch {
            shoppingRepository.deleteAllShopping()
        }
    }

}