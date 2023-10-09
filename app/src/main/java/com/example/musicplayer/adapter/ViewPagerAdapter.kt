package com.example.musicplayer.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.musicplayer.album.AlbumFragment
import com.example.musicplayer.artists.ArtistsFragment
import com.example.musicplayer.playlist.PlaylistFragment

class ViewPagerAdapter(
    fa: FragmentManager,
    lifeCycle: Lifecycle
) : FragmentStateAdapter(fa, lifeCycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ArtistsFragment()
            1 -> AlbumFragment()
            2 -> PlaylistFragment()
            else -> ArtistsFragment()
        }
    }
}