package com.example.marvel.ui.characterDetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation
import com.example.marvel.R
import com.example.marvel.databinding.ViewHolderMarvelCharacterBinding
import com.example.marvel.databinding.ViewHolderMarvelComicsBinding
import com.example.marvel.model.MarvelCharacter
import com.example.marvel.model.MarvelComic
import com.example.marvel.ui.characterList.MarvelCharacterViewHolder

class ComicsViewHolder private constructor(
    private val binding: ViewHolderMarvelComicsBinding
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun newInstance(parent: ViewGroup): ComicsViewHolder {
            return ComicsViewHolder(
                ViewHolderMarvelComicsBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    fun bind(marvelComic: MarvelComic) {
        with(binding){
            comicsName.text = marvelComic.title
            comicsImageView.load("${marvelComic.thumbnail.path}.${marvelComic.thumbnail.extension}") {
                crossfade(true)
                placeholder(R.drawable.ic_iron_man)
                transformations(RoundedCornersTransformation())
            }
        }
    }
}