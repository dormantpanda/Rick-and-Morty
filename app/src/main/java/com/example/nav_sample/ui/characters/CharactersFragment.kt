package com.example.nav_sample.ui.characters

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nav_sample.CharacterListAdapter
import com.example.nav_sample.R
import kotlinx.android.synthetic.main.fragment_characters.*

class CharactersFragment : Fragment(R.layout.fragment_characters) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = CharacterListAdapter()
        rvCharacterList.layoutManager = LinearLayoutManager(requireContext())

        val viewModel = ViewModelProviders.of(this)
            .get(CharacterViewModel::class.java)

        rvCharacterList.adapter = adapter

        viewModel.characterPagedList.observe(requireActivity(), Observer{
            adapter.submitList(it)
        })

    }
}