package authentication

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.example.poc.R
import com.example.poc.databinding.ActivityAuthenticationBinding
import main.SideMenuActivity
import models.Common.toast

class AuthenticationActivity : AppCompatActivity() {

    lateinit var viewModel: AuthenticationViewModel
    lateinit var binding: ActivityAuthenticationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthenticationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[AuthenticationViewModel::class.java]
        viewModel.checkForLogin()

        viewModel.dbData.observe(this) {
            if (it) {
                val i = Intent(applicationContext, SideMenuActivity::class.java)
                i.flags = Intent.FLAG_ACTIVITY_NEW_TASK + Intent.FLAG_ACTIVITY_NO_ANIMATION
                ContextCompat.startActivity(applicationContext, i, Bundle())
                this.finish()
            } else {
                fragmentChange()
                toast(applicationContext, "Please login")
            }
        }


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                supportActionBar?.setDisplayHomeAsUpEnabled(false)
                supportActionBar?.title = "POC"
                fragmentChange()
            }
        }
        return false
    }

    private fun fragmentChange() {
        supportFragmentManager.popBackStack()
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_authentication, LoginFragment()).commit()

    }

}