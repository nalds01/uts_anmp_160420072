package id.ac.ubaya.informatika.satujiwa_nald.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import id.ac.ubaya.informatika.satujiwa_nald.R

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawerLayout)
        navController =
            (supportFragmentManager.findFragmentById(R.id.hostFragment)
                as NavHostFragment).navController

        val navView = findViewById<NavigationView>(R.id.navView)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)


        NavigationUI.setupWithNavController(navView, navController)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)
        bottomNav.setupWithNavController(navController)
    }
    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, drawerLayout)
                || super.onSupportNavigateUp()
    }

}