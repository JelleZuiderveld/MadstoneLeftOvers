package com.example.madstone.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.madstone.R
import com.example.madstone.databinding.ItemSearchBinding
import com.example.madstone.model.SearchIngredient
import kotlinx.android.synthetic.main.item_search.view.*
import java.text.FieldPosition

class SearchAdapter (private val search: List<SearchIngredient>) :
        RecyclerView.Adapter<SearchAdapter.ViewHolder>(){
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private val binding = ItemSearchBinding.bind(itemView)

        fun databind(search: SearchIngredient){
            binding.tvItemSearch.text = search.searchText
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_search, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return search.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        holder.databind(search[position])
    }
}