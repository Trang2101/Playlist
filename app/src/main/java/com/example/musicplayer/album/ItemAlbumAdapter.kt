package com.example.musicplayer.album


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.musicplayer.R


class ItemAlbumAdapter(private val albums: List<String>) :
    RecyclerView.Adapter<ItemAlbumAdapter.AlbumViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_adapter, parent, false)
        return AlbumViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val songs = albums[position]
        holder.bind(songs)
    }

    override fun getItemCount(): Int {
        return albums.size
    }

    inner class AlbumViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val albumNameTextView: TextView = itemView.findViewById(R.id.tv_title)

        fun bind(title: String) {
            albumNameTextView.text = title
        }
    }
}