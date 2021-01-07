package com.example.madstone.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.madstone.R
import com.example.madstone.model.ShoppingList
import com.example.madstone.viemodel.ShoppingViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.android.synthetic.main.fragment_shoppinglist.*

class ShoppingListFragment : Fragment(){

    private val shoppings: ArrayList<ShoppingList> = arrayListOf()
    private val shoppingListAdapter: ShoppingListAdapter = ShoppingListAdapter(shoppings)
    private val shoppingViewModel: ShoppingViewModel by viewModels()
    val testItem = arrayOf("item1", "item2")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?{
        return inflater.inflate(R.layout.fragment_shoppinglist, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        initView()
        observeChanges()
        addItem.setOnClickListener{
            addShoppingItem()
        }

        emtpyBtn.setOnClickListener{
            shoppingViewModel.deleteAllShopping()
            Snackbar.make(requireActivity().findViewById(android.R.id.content),R.string.removed_items, Snackbar.LENGTH_LONG).show()

        }
    }


    private fun initView(){
        recyclerView2.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        recyclerView2.adapter = shoppingListAdapter
        recyclerView2.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))

        creatItemTouchHelper().attachToRecyclerView(recyclerView2)
    }


    private fun addShoppingItem(){
        val name = itemItem.text.toString()

        val shoppingItem = ShoppingList(name)

        shoppingViewModel.addShopping(shoppingItem)
        itemItem.text?.clear()
    }

    private fun creatItemTouchHelper(): ItemTouchHelper{
        val callback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT){

            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val remove = shoppings[position]

                shoppingViewModel.deleteShopping(remove)
            }
        }

        return ItemTouchHelper(callback)
    }


    private fun observeChanges(){
        shoppingViewModel.shoppingData.observe(viewLifecycleOwner, Observer { liveData: List<ShoppingList> ->
            shoppings.clear()
            shoppings.addAll(liveData)
            shoppingListAdapter.notifyDataSetChanged()
        })
    }



}