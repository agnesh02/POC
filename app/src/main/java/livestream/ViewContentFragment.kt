package livestream

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import com.example.poc.R
import com.example.poc.databinding.FragmentViewContentBinding
import models.Common.toast


class ViewContentFragment : Fragment() {

    lateinit var binding: FragmentViewContentBinding
    lateinit var viewModel: LiveStreamViewModel
    private lateinit var url: String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentViewContentBinding.inflate(layoutInflater)

        if(arguments!!.getString("URL") != null)
        {
            url = arguments!!.getString("URL")!!
        }

        binding.webView.settings.javaScriptEnabled = true
        binding.webView.webViewClient = WebViewClient()
        binding.webView.loadUrl(url)

        viewModel = ViewModelProvider(this).get(LiveStreamViewModel::class.java)

        viewModel.msg.observe(viewLifecycleOwner) {
            toast(context!!,it)
        }

        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onPrepareMenu(menu: Menu) {
                super.onPrepareMenu(menu)
                menu.clear()
                activity?.menuInflater?.inflate(R.menu.live_stream_menu, menu)
            }

            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                when(menuItem.itemId)
                {
                    R.id.live_stream_recording -> {
                        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                            ActivityCompat.requestPermissions(requireActivity(), arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), 1)
                        }
                        viewModel.startRecording(url)
                        toast(context!!,"Recording started")
                    }
                }
                return true
            }
        },viewLifecycleOwner, Lifecycle.State.STARTED)

        return binding.root
    }



}