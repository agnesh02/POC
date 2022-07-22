package profile

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import authentication.AuthenticationActivity
import com.example.poc.R
import com.example.poc.databinding.FragmentEditProfileBinding
import main.SideMenuActivity
import models.Common.toast

class EditProfileFragment : Fragment() {

    lateinit var binding: FragmentEditProfileBinding
    lateinit var viewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEditProfileBinding.inflate(layoutInflater)

        viewModel = ViewModelProvider(this)[ProfileViewModel::class.java]
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        val appCompatActivity: AppCompatActivity = (activity as AppCompatActivity)
        appCompatActivity.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        appCompatActivity.supportActionBar?.title = "Edit Profile"

        disableViews()
        viewModel.getProfileData()

        binding.buttonnEditEditProfile.setOnClickListener {
            enableViews()
        }

        binding.btnSaveEditProfile.setOnClickListener {
            viewModel.updateProfileData()
            disableViews()
        }

        viewModel.msg.observeForever {
            if(it == "Profile updated successfully")
            {
                Handler(Looper.getMainLooper()).postDelayed({
                    val i = Intent(requireContext(), SideMenuActivity::class.java)
                    i.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK + Intent.FLAG_ACTIVITY_NEW_TASK
                    i.putExtra("STATUS",false)
                    ContextCompat.startActivity(requireContext(), i, Bundle())
                },500)
            }
        }

        return binding.root
    }

    private fun disableViews() {
        binding.etEditProfileUserName.isEnabled = false
        binding.etEditProfileFullName.isEnabled = false
        binding.etEditProfileDob.isEnabled = false
        binding.etEditProfilePhone.isEnabled = false
        binding.btnSaveEditProfile.visibility = View.INVISIBLE
        binding.buttonnEditEditProfile.visibility = View.VISIBLE
    }

    private fun enableViews() {
        binding.etEditProfileUserName.isEnabled = true
        binding.etEditProfileFullName.isEnabled = true
        binding.etEditProfileDob.isEnabled = true
        binding.etEditProfilePhone.isEnabled = true
        binding.btnSaveEditProfile.visibility = View.VISIBLE
        binding.buttonnEditEditProfile.visibility = View.INVISIBLE
    }

}