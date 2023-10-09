package com.example.musicplayer.album

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.musicplayer.R


class AlbumFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var albumAdapter: ItemAlbumAdapter
    private var listAlbum = listOf("Album 1", "Album 2", "Album 3")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_album, container, false)

        recyclerView = view.findViewById(R.id.rv_album)
        albumAdapter = ItemAlbumAdapter(listAlbum)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = albumAdapter

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            AlbumFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}