package com.example.madstone.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.madstone.R
import com.example.madstone.model.Recipe
import kotlinx.android.synthetic.main.fragment_recipe.view.*
import kotlinx.android.synthetic.main.item_result.view.*
import kotlinx.android.synthetic.main.item_shoppinglist.view.*
import java.util.*
import kotlin.collections.ArrayList

class ResultAdapter(private var recipe: ArrayList<Recipe>) :RecyclerView.Adapter<ResultAdapter.ViewHolder>(), Filterable{

    var recipeFilterList = ArrayList<Recipe>()
    init {
        recipeFilterList = Recipe.populateData()
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun databind(recipe: Recipe){
            itemView.select_recipe.text = recipe.title

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_result, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return recipeFilterList.size
    }

    override fun onBindViewHolder(holder: ResultAdapter.ViewHolder, position: Int) {
        holder.itemView.select_recipe.text = recipeFilterList[position].title
        holder.itemView.image_recipe.setImageResource(recipeFilterList[position].image)
        holder.itemView.description.text = recipeFilterList[position].description
        holder.itemView.ingredient_list.text = recipeFilterList[position].ingredients
        holder.itemView.prepare_explain.text = recipeFilterList[position].prepare
    }

    @Suppress("UNCHECKED_CAST")
    override fun getFilter(): Filter {
        return object : Filter(){
            override fun performFiltering(constraint: CharSequence?): Filter.FilterResults {
                val charSearch = constraint.toString()
                if(charSearch.isBlank()){
                    recipeFilterList.clear()
                }else{
                    recipeFilterList.clear()
                    recipeFilterList.addAll(Recipe.populateData())
                    val resultList = ArrayList<Recipe>()
                    for(row in recipeFilterList){
                        if(row.ingredients.toLowerCase(Locale.ROOT).contains(charSearch.toLowerCase(Locale.ROOT))){
                            resultList.add(row)
                        }
                    }
                    recipeFilterList = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = recipeFilterList
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, filterResults: Filter.FilterResults?) {
                recipeFilterList = filterResults?.values as ArrayList<Recipe>
                notifyDataSetChanged()
            }


        }
    }




}