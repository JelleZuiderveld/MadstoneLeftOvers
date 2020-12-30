package com.example.madstone.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.madstone.R
import com.example.madstone.model.ShoppingList
import kotlinx.android.synthetic.main.item_shoppinglist.view.*
import java.text.FieldPosition

class ShoppingListAdapter (private val shoppingList: List<ShoppingList>): RecyclerView.Adapter<ShoppingListAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_shoppinglist, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return shoppingList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.databind(shoppingList[position])
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun databind(shopping: ShoppingList){
            itemView.tvItemList.text = shopping.name
        }
    }
}
