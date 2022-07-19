package livestream

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.poc.R
import com.example.poc.databinding.FragmentLiveStreamBinding
import models.Common.toast


class LiveStreamFragment : Fragment() {

    lateinit var binding: FragmentLiveStreamBinding
    lateinit var viewModel: LiveStreamViewModel
    //var videoURI = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
    //var videoURI = "https://192.168.1.12:8080/video"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentLiveStreamBinding.inflate(layoutInflater)

        viewModel = ViewModelProvider(this)[LiveStreamViewModel::class.java]
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.msg.observe(viewLifecycleOwner) {

            toast(context!!, it)

            if(it.equals("Loaded successfully"))
            {
                val fragment = ViewContentFragment()
                val bundle = Bundle()
                bundle.putString("URL", viewModel.url)
                fragment.arguments = bundle

                parentFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment_content_side_menu, fragment)
                    .commit()

            }
        }


        return binding.root
    }

}