package profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.poc.R
import com.example.poc.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    lateinit var binding: FragmentProfileBinding
    lateinit var viewModel: ProfileViewModel
    private var uri: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[ProfileViewModel::class.java]
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.getProfileData()

        viewModel.uri.observe(viewLifecycleOwner) {
            uri = it
            Glide.with(context!!)
                .load(it)
                .fitCenter()
                .placeholder(R.drawable.ic_baseline_person_pin_24)
                .into(binding.profileProfilePic)

        }

        binding.tvGoToEditProfile.setOnClickListener {
            fragmentChange(EditProfileFragment())
        }

        binding.profileProfilePic.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("image_uri", uri)
            val fragment: Fragment = ProfilePictureFragment()
            fragment.arguments = bundle
            fragmentChange(fragment)
        }

        viewModel.msg.observe(viewLifecycleOwner) {
            if (it.equals("ok"))
                binding.progressBarProfile.visibility = View.INVISIBLE
        }

        return binding.root
    }

    private fun fragmentChange(fragment: Fragment) {
        val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
        transaction.replace(R.id.nav_host_fragment_content_side_menu, fragment).commit()
    }


}