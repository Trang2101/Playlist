package com.example.musicplayer.playlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.musicplayer.Music
import com.example.musicplayer.R


class ItemPlaylistAdapter(private val songs: List<Music>, private val onItemClickListener: (Music) -> Unit) :
    RecyclerView.Adapter<ItemPlaylistAdapter.PlaylistViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_adapter, parent, false)
        return PlaylistViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        val songs = songs[position]
        holder.bind(songs)
    }

    override fun getItemCount(): Int {
        return songs.size
    }

    inner class PlaylistViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val singerNameTextView: TextView = itemView.findViewById(R.id.tv_title)

        fun bind(title: Music) {
            singerNameTextView.text = title.name
            itemView.setOnClickListener {
                onItemClickListener.invoke(title)
            }
        }
    }
}