package com.example.madstone.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Query
import com.example.madstone.R
import com.example.madstone.database.LeftOverDatabase
import com.example.madstone.databinding.FragmentSearchBinding
import com.example.madstone.model.Recipe
import com.example.madstone.model.SearchIngredient
import kotlinx.android.synthetic.main.fragment_search.*
import java.util.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SearchFragment : Fragment() {

    private val searches = arrayListOf<SearchIngredient>()
    private val searchAdapter = SearchAdapter(searches)
    private lateinit var binding: FragmentSearchBinding
    private val leftoverDatabase = LeftOverDatabase.getDatabase(requireContext())

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()

        back_home.setOnClickListener {
            (context as MainActivity).replaceFragment(HomeFragment())
        }
        lookForRecipe()
    }

    private fun initViews(){
        binding.recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding.recyclerView.adapter = searchAdapter
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                context,
                DividerItemDecoration.VERTICAL
            )
        )

        binding.addIngredientSearch.setOnClickListener{
            val searching = binding.textInputEditText.text.toString()
            addIngredient(searching)
        }
    }

    private fun addIngredient(search: String){
        if(search.isNotBlank()){
            searches.add(SearchIngredient(search))
            searchAdapter.notifyDataSetChanged()
            binding.textInputEditText.text?.clear()
        }
    }

    private fun onSearch(searchText: String){
//        searchBtn.setOnClickListener {
//            (context as MainActivity).replaceFragment(ResultFragment())
//        }
        val searchText = "$searchText%"
        leftoverDatabase!!.recipeDao().getRecipeIngredient(searchText)
            .observe(this, object : Observer<List<Recipe>>{
                override fun onChanged(recipe: List<Recipe>?){
                    if (recipe == null){
                        return
                    }
                    val adapter = searchAdapter(
                        this@SearchFragment,
                        R.layout.item_search,
                        recipe
                    )
                    lvSearchResults.adapter = adapter
                }
            })
    }


    fun lookForRecipe(query: String):Boolean{
        onSearch(query)
        return true
    }
}