package com.example.marvel.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel.R
import com.example.marvel.databinding.ViewHolderMarvelCharacterBinding
import com.example.marvel.model.MarvelCharacter
import com.squareup.picasso.Picasso

class CharacterAdapter(
    private val context: Context,
    private var characterList: List<MarvelCharacter>
) :
    RecyclerView.Adapter<MarvelCharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarvelCharacterViewHolder {
        return MarvelCharacterViewHolder.newInstance(parent)
    }

    override fun onBindViewHolder(holder: MarvelCharacterViewHolder, position: Int) {
        holder.bind(characterList[position])
    }

    override fun getItemCount() = characterList.size

    fun updateValue(list: List<MarvelCharacter>) {
        characterList = list
        notifyDataSetChanged()
    }
}