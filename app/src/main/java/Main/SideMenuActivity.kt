package Main

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.*
import com.example.poc.R
import com.example.poc.databinding.ActivitySideMenuBinding
import com.example.poc.databinding.NavHeaderSideMenuBinding
import com.google.android.material.navigation.NavigationView

class SideMenuActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivitySideMenuBinding
    private lateinit var viewModel:DashboardViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySideMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.appBarSideMenu.toolbar)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(this,R.id.nav_host_fragment_content_side_menu)

        val viewHeader = binding.navView.getHeaderView(0)
        val navViewHeaderBinding : NavHeaderSideMenuBinding = NavHeaderSideMenuBinding.bind(viewHeader)

        appBarConfiguration = AppBarConfiguration(setOf(R.id.nav_dashboard, R.id.nav_profile), drawerLayout)
        NavigationUI.setupActionBarWithNavController(this,navController, appBarConfiguration)
        NavigationUI.setupWithNavController(navView,navController)

        viewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)
        viewModel.getUser()
        viewModel.uname.observeForever(Observer {
            navViewHeaderBinding.tvHeaderUname.text = it
        })
        viewModel.email.observeForever(Observer {
            navViewHeaderBinding.tvHeaderEmail.text = it
        })


        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_dashboard -> { navController.navigate(R.id.nav_dashboard); drawerLayout.closeDrawer(GravityCompat.START); true }
                R.id.nav_profile ->  {navController.navigate(R.id.nav_profile); drawerLayout.closeDrawer(GravityCompat.START); true}
                R.id.nav_logout -> { performLogout(); true}
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

    private fun performLogout() {

        val builder = AlertDialog.Builder(this)
        builder.setCancelable(false)
        builder.setTitle("Logout")
        builder.setMessage("Are you sure you want to logout ? ")
        builder.setIcon(android.R.drawable.ic_dialog_alert)

        builder.setPositiveButton("Yes"){dialogInterface, which ->
            viewModel.performLogout()
        }

        builder.setNegativeButton("Cancel"){dialogInterface , which ->
            dialogInterface.dismiss()
        }

        val alertDialog: AlertDialog = builder.create()
        alertDialog.show()

    }


}