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
import com.example.madstone.R
import com.example.madstone.databinding.FragmentSearchBinding
import com.example.madstone.model.SearchIngredient
import kotlinx.android.synthetic.main.fragment_search.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SearchFragment : Fragment() {

    private val searches = arrayListOf<SearchIngredient>()
    private val searchAdapter = SearchAdapter(searches)
    private lateinit var binding: FragmentSearchBinding

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
        onSearch()
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

    private fun onSearch(){
        searchBtn.setOnClickListener {
            (context as MainActivity).replaceFragment(ResultFragment())
        }
    }
}