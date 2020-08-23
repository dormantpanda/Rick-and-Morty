package com.example.nav_sample.ui.characters

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nav_sample.CharacterListAdapter
import com.example.nav_sample.R
import com.example.nav_sample.ui.character_info.CharacterInfoFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_characters.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharactersFragment : Fragment(R.layout.fragment_characters) {

    private val viewModel: CharacterViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = CharacterListAdapter()

        adapter.onItemClick = {
            NavHostFragment.findNavController(this)
                .navigate(R.id.toCharacterInfo,  CharacterInfoFragment.getBundle(it))
        }

        rvCharacterList.layoutManager = LinearLayoutManager(requireContext())
        rvCharacterList.adapter = adapter

        viewModel.characterPagedList.observe(requireActivity(), Observer{
            adapter.submitList(it)
        })

    }
}