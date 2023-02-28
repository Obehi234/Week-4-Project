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
            R.id.productsFragment ->  Product()
            R.id.paymentsFragment ->  Payments()
            R.id.historyFragment -> History()
            R.id.supportFragment -> Support()
            R.id.moreFragment -> More()
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