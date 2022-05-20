package com.example.marvel.ui.characterDetail

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel.model.MarvelComic

class ComicsAdapter(private val comics: List<MarvelComic>):
    RecyclerView.Adapter<ComicsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicsViewHolder {
        return ComicsViewHolder.newInstance(parent)
    }

    override fun onBindViewHolder(holder: ComicsViewHolder, position: Int) {
        holder.bind(comics[position])
    }

    override fun getItemCount(): Int {
        return comics.size
    }
}