package com.example.musicplayer.playlist

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musicplayer.Music
import com.example.musicplayer.MyService
import com.example.musicplayer.R
import com.example.musicplayer.ViewSongFragment
import com.example.musicplayer.databinding.FragmentPlaylistBinding


class PlaylistFragment : Fragment() {
    private lateinit var binding: FragmentPlaylistBinding
    private lateinit var itemPlaylistAdapter: ItemPlaylistAdapter
    private val listMusic = Music.getList()
    private var myService: MyService? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPlaylistBinding.inflate(inflater, container, false)
        itemPlaylistAdapter = ItemPlaylistAdapter(listMusic) { selected ->
            showFragmentB(selected)
        }

        binding.rvPlaylist.layoutManager = LinearLayoutManager(requireContext())
        binding.rvPlaylist.adapter = itemPlaylistAdapter

        return binding.root
    }
    private fun showFragmentB(selectedSong: Music) {
        val viewSongFragment = ViewSongFragment(selectedSong)
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, viewSongFragment)
            .addToBackStack(null)
            .commit()
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            PlaylistFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

}