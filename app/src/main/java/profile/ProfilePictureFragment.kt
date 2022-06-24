package profile

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.poc.R
import com.example.poc.databinding.FragmentProfilePictureBinding


class ProfilePictureFragment : Fragment() {

    lateinit var binding: FragmentProfilePictureBinding
    lateinit var viewModel: ProfileViewModel
    private lateinit var uri: Uri

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentProfilePictureBinding.inflate(layoutInflater)

        viewModel = ViewModelProvider(this)[ProfileViewModel::class.java]
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        val appCompatActivity: AppCompatActivity = activity as AppCompatActivity
        appCompatActivity.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        appCompatActivity.supportActionBar?.title = "Profile Picture"

        val bundle = this.arguments

        if (bundle != null) {

            if (!bundle.getString("image_uri").equals("")) {
                Glide.with(context!!)
                    .load(bundle.getString("image_uri"))
                    .fitCenter()
                    .placeholder(R.drawable.ic_baseline_person_pin_24)
                    .into(binding.picture)
            }
        }

        binding.btnChooseImage.setOnClickListener {
            getContent.launch("image/*")
        }

        binding.btnUploadImage.setOnClickListener {
            viewModel.uploadProfilePicture(uri)
            Toast.makeText(
                context,
                "Uploading please wait...\nThis depends upon your network speed",
                Toast.LENGTH_LONG
            ).show()
            binding.progressBarProfilePic.visibility = View.VISIBLE
        }

        viewModel.msg.observe(viewLifecycleOwner) {
            if (it.equals("Image has been uploaded successfully")) {
                binding.progressBarProfilePic.visibility = View.INVISIBLE
                binding.btnUploadImage.visibility = View.INVISIBLE
            }
        }

        return binding.root
    }

    private val getContent = registerForActivityResult(ActivityResultContracts.GetContent()) {
        if (it != null) {
            uri = it
            binding.picture.setImageURI(it)
            binding.btnUploadImage.visibility = View.VISIBLE
            Toast.makeText(context, "An image has been selected", Toast.LENGTH_SHORT).show()
        }
    }


}