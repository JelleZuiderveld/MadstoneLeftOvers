package com.example.madstone.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.madstone.R
import com.example.madstone.database.LeftOverDatabase
import kotlinx.android.synthetic.main.fragment_results.*
import kotlinx.android.synthetic.main.fragment_search.*

class ResultFragment: Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_results, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        back_search.setOnClickListener {
            (context as MainActivity).replaceFragment(SearchFragment())
        }
    }



}