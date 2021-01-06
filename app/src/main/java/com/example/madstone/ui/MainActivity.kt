package com.example.madstone.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.madstone.R
import com.example.madstone.database.LeftOverDatabase
import com.example.madstone.model.Recipe
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {item ->
        when(item.itemId){
            R.id.nav_home->{
                replaceFragment(HomeFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_list->{
                replaceFragment(ShoppingListFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_map->{
                replaceFragment((MapFragment()))
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        replaceFragment(HomeFragment())

//        val navView: BottomNavigationView = findViewById(R.id.bottom_navigation)
//
//
//        navView.setOnNavigationItemSelectedListener { item ->
//
//            when (item.itemId){
//
//                R.id.nav_home ->{
//                    homeFragment = HomeFragment()
//                    supportFragmentManager
//                        .beginTransaction()
//                        .replace(R.id.frame_layout, homeFragment)
//                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
//                        .commit()
//                }
//
//                R.id.nav_list ->{
//                    shoppingListFragment = ShoppingListFragment()
//                    supportFragmentManager
//                        .beginTransaction()
//                        .replace(R.id.frame_layout, shoppingListFragment)
//                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
//                        .commit()
//                }
//
//                R.id.nav_map ->{
//                    mapFragment = MapFragment()
//                    supportFragmentManager
//                        .beginTransaction()
//                        .replace(R.id.frame_layout, mapFragment)
//                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
//                        .commit()
//                }
//            }
//
//            true
//        }

//        val navController = findNavController(R.id.nav_host_fragment)
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        val appBarConfiguration = AppBarConfiguration(setOf(
//            R.id.nav_home, R.id.nav_list, R.id.nav_map))
//        //setupActionBarWithNavController(navController, appBarConfiguration)
//        navView.setupWithNavController(navController)
    }


    fun replaceFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()
    }

//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        menuInflater.inflate(R.menu.bottom_navigation_menu, menu)
//        return true
//    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        return when (item.itemId) {
//            R.id.action_settings -> true
//            else -> super.onOptionsItemSelected(item)
//        }
//    }
}