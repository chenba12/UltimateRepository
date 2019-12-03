package com.template.ultimaterepository

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        setSupportActionBar(toolbar)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        navController = this.findNavController(R.id.myNavHostFragment)
        toolbar.elevation = 4.0F
    }
}
