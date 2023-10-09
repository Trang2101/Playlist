package com.example.musicplayer.artists

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.musicplayer.R


class ArtistsFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var itemArtistsAdapter: ItemArtistsAdapter
    private var listArtis = listOf("Kiên", "Vân", "Chuột sấm sét")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_artists, container, false)
        recyclerView = view.findViewById(R.id.rv_artist)
        itemArtistsAdapter = ItemArtistsAdapter(listArtis)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = itemArtistsAdapter

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ArtistsFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}