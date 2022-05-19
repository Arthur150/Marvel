package com.example.marvel.ui.characterList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.example.marvel.R
import com.example.marvel.databinding.ViewHolderMarvelCharacterBinding
import com.example.marvel.model.MarvelCharacter

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
        with(binding){
            root.setOnClickListener { view ->
                val bundle = bundleOf("characterId" to marvelCharacter.id)
                view.findNavController().navigate(
                    R.id.action_characterListFragment_to_characterDetailFragment,
                    bundle
                )
            }
            characterName.text = marvelCharacter.name
            characterImage.load("${marvelCharacter.thumbnail.path}.${marvelCharacter.thumbnail.extension}") {
                crossfade(true)
                placeholder(R.drawable.ic_iron_man)
                transformations(CircleCropTransformation())
            }
        }
    }
}