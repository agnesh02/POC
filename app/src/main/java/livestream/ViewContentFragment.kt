package livestream

import android.Manifest
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.webkit.WebViewClient
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import com.example.poc.R
import com.example.poc.databinding.FragmentViewContentBinding
import models.Common.toast
import pub.devrel.easypermissions.AppSettingsDialog
import pub.devrel.easypermissions.EasyPermissions

class ViewContentFragment : Fragment(), EasyPermissions.PermissionCallbacks {

    lateinit var binding: FragmentViewContentBinding
    lateinit var viewModel: LiveStreamViewModel
    private lateinit var url: String
    private var recordingState = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentViewContentBinding.inflate(layoutInflater)

        if(arguments!!.getString("URL") != null)
        {
            url = arguments!!.getString("URL")!!
        }

        binding.webView.settings.javaScriptEnabled = true
        binding.webView.webViewClient = WebViewClient()
        binding.webView.loadUrl(url)

        viewModel = ViewModelProvider(this)[LiveStreamViewModel::class.java]

        viewModel.msg.observe(viewLifecycleOwner) {
            toast(context!!,it)
        }

        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onPrepareMenu(menu: Menu) {
                super.onPrepareMenu(menu)
                menu.clear()
                activity?.menuInflater?.inflate(R.menu.live_stream_menu, menu)
                val menuItem = menu.findItem(R.id.live_stream_recording)

                if(recordingState)
                {
                    if (menuItem.title == "Start Recording")
                        menuItem.title = "Stop Recording"
                    else
                        menuItem.title = "Start Recording"
                }

            }

            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {

            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                when(menuItem.itemId)
                {
                    R.id.live_stream_recording -> {
                        if (!hasStoragePermission()) {
                           requestStoragePermission()
                        }
                        else
                        {
                            if(menuItem.title == "Start Recording")
                            {
                                viewModel.startRecording(url)
                                toast(context!!,"Recording started")
                                recordingState = true
                            }
                            else
                            {
                                viewModel.stopRecording()
                                //toast(context!!,"Recording stopped")
                                recordingState = false
                            }
                        }

                    }
                }
                return true
            }
        },viewLifecycleOwner, Lifecycle.State.STARTED)

        return binding.root
    }

    private fun hasStoragePermission() = EasyPermissions.hasPermissions(requireContext(),Manifest.permission.WRITE_EXTERNAL_STORAGE)

    private fun requestStoragePermission()
    {
        EasyPermissions.requestPermissions(this,"Storage permission is necessary to save the recordings",1,Manifest.permission.WRITE_EXTERNAL_STORAGE)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        //super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }

    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {
        toast(requireContext(), "Permission granted")
    }

    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
        if(EasyPermissions.permissionPermanentlyDenied(this, perms.first()))
            AppSettingsDialog.Builder(requireActivity()).build().show()
        else
            requestStoragePermission()
    }


}