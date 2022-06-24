package main

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.poc.R
import com.example.poc.databinding.FragmentDashboardBinding


class DashboardFragment : Fragment() {

    lateinit var binding: FragmentDashboardBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDashboardBinding.inflate(layoutInflater)

        val appCompatActivity: AppCompatActivity = activity as AppCompatActivity
        appCompatActivity.supportActionBar?.title = "Dashboard"

        binding.cardProfile.setOnClickListener {
            view?.findNavController()?.navigate(R.id.nav_profile)
        }

        return binding.root
    }

}