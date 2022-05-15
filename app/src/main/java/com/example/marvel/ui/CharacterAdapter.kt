package com.example.marvel.ui

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.marvel.model.MarvelCharacter

class CharacterAdapter(
    differCallback: DiffUtil.ItemCallback<MarvelCharacter>
) : PagingDataAdapter<MarvelCharacter, MarvelCharacterViewHolder>(differCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarvelCharacterViewHolder {
        return MarvelCharacterViewHolder.newInstance(parent)
    }

    override fun onBindViewHolder(holder: MarvelCharacterViewHolder, position: Int) {
        val character = getItem(position)
        character?.let { holder.bind(it) }
    }
}