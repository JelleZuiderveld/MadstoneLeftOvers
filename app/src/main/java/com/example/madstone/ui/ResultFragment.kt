package com.example.madstone.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.madstone.R
import androidx.lifecycle.Observer
import com.example.madstone.model.Recipe
import com.example.madstone.viemodel.RecipeViewModel
import kotlinx.android.synthetic.main.fragment_results.*
import kotlin.math.log

class ResultFragment: Fragment(){

    private val recipe: ArrayList<Recipe> = arrayListOf()
    private val resultAdapter: ResultAdapter = ResultAdapter(recipe, {item: Recipe -> itemClicked(item)})
    private val recipeViewModel: RecipeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_results, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observeChanges()

        back_search.setOnClickListener {
            (context as MainActivity).replaceFragment(HomeFragment())
        }
    }


    private fun initView(){
        rv_results.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        rv_results.adapter = resultAdapter
        rv_results.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))

//        searchResults.setOnQueryTextListener(object: SearchView.OnQueryTextListener,
//            androidx.appcompat.widget.SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(query: String?): Boolean{
//                return false
//            }
//            override fun onQueryTextChange(newText: String?): Boolean {
//                resultAdapter.filter.filter(newText)
//                return false
//            }
//        })
    }


    private fun observeChanges(){
        recipeViewModel.recipeData.observe(viewLifecycleOwner, Observer { liveData: List<Recipe> ->
            recipe.clear()
            recipe.addAll(liveData)
            resultAdapter.notifyDataSetChanged()
        })
    }

    private fun itemClicked(item: Recipe){
        Log.println(Log.INFO, item.title, item.title)
    }

}