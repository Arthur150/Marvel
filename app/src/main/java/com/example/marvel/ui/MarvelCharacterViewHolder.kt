package com.example.marvel.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel.R
import com.example.marvel.databinding.ViewHolderMarvelCharacterBinding
import com.example.marvel.model.MarvelCharacter
import com.squareup.picasso.Picasso

class MarvelCharacterViewHolder private constructor(
    private val binding: ViewHolderMarvelCharacterBinding
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun newInstance(parent: ViewGroup): MarvelCharacterViewHolder {
            return MarvelCharacterViewHolder(
                ViewHolderMarvelCharacterBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    fun bind(marvelCharacter: MarvelCharacter) {
        binding.characterName.text = marvelCharacter.name
        Picasso.with(binding.root.context)
            .load("${marvelCharacter.thumbnail.path}.${marvelCharacter.thumbnail.extension}")
            .placeholder(R.drawable.ic_iron_man)
            .error(R.drawable.ic_iron_man)
            .into(binding.characterImage)
    }
}