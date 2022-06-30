package profile

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.example.poc.R
import com.example.poc.databinding.FragmentEditProfileBinding

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
            val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.nav_host_fragment_content_side_menu, ProfileFragment())
                .commit()
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