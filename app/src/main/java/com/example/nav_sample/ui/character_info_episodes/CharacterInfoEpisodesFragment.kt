package com.example.nav_sample.ui.character_info_episodes

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nav_sample.CharacterEpisodeListAdapter
import com.example.nav_sample.R
import com.example.nav_sample.models.characters.Character
import com.example.nav_sample.ui.character_info.CharacterInfoFragment
import kotlinx.android.synthetic.main.fragment_episodes.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterInfoEpisodesFragment : Fragment(R.layout.fragment_episodes) {

    private val viewModel: CharacterEpisodesViewModel by viewModel()

    companion object {
        private const val EXTRA_CHARACTER = "extra_character"

        fun getBundle(character: Character): Bundle {
            return Bundle().apply {
                putParcelable(EXTRA_CHARACTER, character)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val character: Character? = arguments?.getParcelable(EXTRA_CHARACTER)
        var episodesId = ""
        character?.let {
            episodesId = getEpisodesId(character)
        }

        val adapter = CharacterEpisodeListAdapter()

        rvEpisodesList.layoutManager = LinearLayoutManager(requireContext())
        rvEpisodesList.adapter = adapter

        viewModel.loadEpisodes(episodesId)
        viewModel.screenState.observe(requireActivity(), Observer{
            adapter.setEpisodes(it)
        })
    }

    fun getEpisodesId(character: Character) : String{
        var result = ""
        character.episode?.map {
            result += it.substringAfterLast("episode/") + ","
        }
        return (result.substring(0, result.length - 1))
    }

}