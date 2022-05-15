package com.example.marvel.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel.R
import com.example.marvel.model.MarvelCharacter
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterListFragment : Fragment() {

    private val viewModel by viewModel<CharacterListViewModel>()

    private val characterAdapter = CharacterAdapter(MarvelCharacter.Companion)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_character_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.characterList)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        recyclerView.adapter = characterAdapter

        lifecycleScope.launchWhenStarted {
            viewModel.characterList.collectLatest { pagingData ->
                characterAdapter.submitData(pagingData)
            }
        }
    }
}