package com.example.madstone.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.madstone.R
import com.example.madstone.model.Recipe
import kotlinx.android.synthetic.main.item_result.view.*
import kotlinx.android.synthetic.main.item_shoppinglist.view.*
import java.util.*
import kotlin.collections.ArrayList

class ResultAdapter(private var recipe: ArrayList<Recipe>, val clickListener: (Recipe) -> Unit) :RecyclerView.Adapter<ResultAdapter.ViewHolder>(){

    var recipeFilterList = ArrayList<Recipe>()
    init {
        recipeFilterList = recipe
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun databind(recipe: Recipe, clickListener: (Recipe) -> Unit){
            itemView.select_recipe.text = recipe.title
            itemView.setOnClickListener{clickListener(recipe)}
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_result, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return recipe.size
    }

    override fun onBindViewHolder(holder: ResultAdapter.ViewHolder, position: Int) {
        holder.databind(recipe[position], clickListener)
    }

//    override fun getFilter(): Filter {
//        return object : Filter(){
//            override fun performFiltering(constraint: CharSequence?): FilterResults {
//                val charSearch = constraint.toString()
//                if(charSearch.isEmpty()){
//
//                }else{
//                    val resultList = ArrayList<Recipe>()
//                    for(row in recipe.filter { it.title == charSearch }){
//                        if(row.title.toLowerCase(Locale.ROOT).contains(charSearch.toLowerCase(
//                                Locale.ROOT))){
//                            resultList.add(row)
//                        }
//                    }
//                    recipeFilterList = resultList
//                }
//                val filterResults = FilterResults()
//                filterResults.values = recipeFilterList
//                return filterResults
//            }
//            @Suppress("UNCHECKED_CAST")
//            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
//                recipeFilterList = results?.values as ArrayList<Recipe>
//                notifyDataSetChanged()
//            }
//        }
//    }


}