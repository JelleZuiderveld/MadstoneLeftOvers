package com.example.madstone.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.madstone.R
import com.example.madstone.model.Recipe

class ResultAdapter (context: Context, val layout: Int, val recipe: List<Recipe>) : ArrayAdapter<Recipe>(context, layout, recipe){
    override fun getCount(): Int {
        return recipe.size
    }

    override fun getItem(position: Int): Recipe? {
        return recipe.get(position)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View{
        var retView: View
        var vi = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        if(convertView == null){
            retView = vi.inflate(layout, null)
        }else{
            retView = convertView
        }
        var recipeItem = getItem(position)
        val recipeName = retView.findViewById(R.id.textInputEditText) as TextView
        recipeName.text = recipeItem!!.title
        return retView
    }
}