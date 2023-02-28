package com.example.week4project

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.week4project.navFragment.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//Bottom Navigation Code
        val bottomBar = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomBar.setOnNavigationItemSelectedListener(this)
        loadFragment(Product())
        }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var fragment: Fragment = when(item.itemId) {
            R.id.navigation_products ->  Product()
            R.id.navigation_payments ->  Payments()
            R.id.navigation_history -> History()
            R.id.navigation_support -> Support()
            R.id.navigation_more -> More()
            else -> Product()
        }
        loadFragment(fragment)
        return true
    }
    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.relativelayout, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}