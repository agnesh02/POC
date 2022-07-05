package livestream

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.poc.databinding.FragmentLiveStreamBinding
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem


class LiveStreamFragment : Fragment() {

    lateinit var binding: FragmentLiveStreamBinding
    //var videoURI = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
    //var videoURI = "https://192.168.1.12:8080/video"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentLiveStreamBinding.inflate(layoutInflater)

//        var simpleExoPlayer = ExoPlayer.Builder(requireContext()).build()
//        binding.btnPlayContent.setOnClickListener(View.OnClickListener {
//            binding.videoView.player = simpleExoPlayer
//            var mediaItem: MediaItem = MediaItem.fromUri(videoURI)
//            simpleExoPlayer.addMediaItem(mediaItem)
//            simpleExoPlayer.playWhenReady = true
//        })




        return binding.root
    }


}