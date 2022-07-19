package authentication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.example.poc.R
import com.example.poc.databinding.FragmentSplashBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import main.SideMenuActivity
import models.Common


class SplashScreenActivity : AppCompatActivity() {

    lateinit var binding: FragmentSplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentSplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch(Dispatchers.Default) {
            val sUri = "android.resource://" + packageName + "/" + R.raw.poc
            val uri = Uri.parse(sUri)
            binding.videoView.setVideoURI(uri)
            binding.videoView.requestFocus()
            binding.videoView.start()
        }

        Handler(Looper.getMainLooper()).postDelayed({
            val i = Intent(applicationContext, AuthenticationActivity::class.java)
            i.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            ContextCompat.startActivity(applicationContext, i, Bundle())
            this.finish()
        },3000)

    }

}