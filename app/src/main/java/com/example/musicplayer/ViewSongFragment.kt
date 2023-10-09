package com.example.musicplayer

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.musicplayer.databinding.FragmentViewSongBinding

class ViewSongFragment(val selectedSong: Music) : Fragment() {
    private lateinit var binding: FragmentViewSongBinding
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var runnable: Runnable

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentViewSongBinding.inflate(inflater, container, false)
        startMusicService()
        return binding.root
    }

    private fun startMusicService() {
        val intent = Intent(requireActivity(), MyService::class.java)
        requireActivity().startService(intent)
    }
//    private fun fillView(music: Music) {
//        binding.tvName.text = music.name
//        binding.sbMusic.progress = 0
//        binding.sbMusic.max = mediaPlayer.duration
//        binding.tvStart.text = String.format("%d:%02d", 0, 0)
//        binding.imgAvatar.setImageBitmap(music.img)
//        binding.tvEnd.text = timeFormat(mediaPlayer.duration / 1000)
//    }
//
//    private fun timeFormat(currentInSeconds: Int): String {
//        val minutes = currentInSeconds / 60
//        val second = currentInSeconds % 60
//        return String.format("%d:%02d", minutes, second)
//    }
//
//    override fun onPause() {
//        super.onPause()
//        lifecycleScope.cancel()
//        handle.removeCallbacks(runnable)
//    }
}