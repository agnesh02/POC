package authentication

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentTransaction
import androidx.room.Room
import com.example.poc.R
import main.SideMenuActivity
import models.database.Database

class AuthenticationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)

        val db = Room.databaseBuilder(applicationContext, Database::class.java, "userdb")
            .allowMainThreadQueries().build()
        val dbData: Boolean = db.accessDao().getData()
//        val list = db.accessDao().getData2()
//        Log.d("TEST2",list.toString())
//        Log.d("TEST",dbData.toString())

        if (dbData) {
            val i = Intent(applicationContext, SideMenuActivity::class.java)
            i.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            ContextCompat.startActivity(applicationContext, i, Bundle())
        } else {
            fragmentChange()
            Toast.makeText(applicationContext, "Please login", Toast.LENGTH_SHORT).show()
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
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_authentication, LoginFragment()).commit()

    }

}