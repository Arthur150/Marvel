package com.example.marvel.ui.characterDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.example.marvel.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterDetailFragment : Fragment() {

    private val viewModel by viewModel<CharacterDetailViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewModel.loadCharacter(requireArguments().getInt("characterId"))
        return inflater.inflate(R.layout.fragment_character_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.characterDetailRecyclerView)
        val characterImageView = view.findViewById<ImageView>(R.id.characterDetailImageView)
        val characterName = view.findViewById<TextView>(R.id.characterDetailName)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        viewModel.getCharacter().observe(viewLifecycleOwner){ marvelCharacter ->
            characterName.text = marvelCharacter.name
            characterImageView.load("${marvelCharacter.thumbnail.path}.${marvelCharacter.thumbnail.extension}") {
                crossfade(true)
                placeholder(R.drawable.ic_iron_man)
                transformations(CircleCropTransformation())
            }
        }
    }
}