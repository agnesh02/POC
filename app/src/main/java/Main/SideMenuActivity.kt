package Main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.*
import com.example.poc.R
import com.example.poc.databinding.ActivitySideMenuBinding
import com.google.android.material.navigation.NavigationView

class SideMenuActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivitySideMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySideMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.appBarSideMenu.toolbar)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(this,R.id.nav_host_fragment_content_side_menu)

        appBarConfiguration = AppBarConfiguration(setOf(R.id.nav_dashboard, R.id.nav_profile), drawerLayout)
        NavigationUI.setupActionBarWithNavController(this,navController, appBarConfiguration)
        NavigationUI.setupWithNavController(navView,navController)

        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_dashboard -> { navController.navigate(R.id.nav_dashboard); drawerLayout.closeDrawer(GravityCompat.START); true }
                R.id.nav_profile ->  {navController.navigate(R.id.nav_profile); drawerLayout.closeDrawer(GravityCompat.START); true}

                else -> false
            }
        }


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.side_menu, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(this,R.id.nav_host_fragment_content_side_menu)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }


}