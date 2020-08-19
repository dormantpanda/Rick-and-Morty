package com.example.nav_sample.ui.episodes

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nav_sample.EpisodeListAdapter
import com.example.nav_sample.R
import kotlinx.android.synthetic.main.fragment_episodes.*

class EpisodesFragment : Fragment(R.layout.fragment_episodes) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = EpisodeListAdapter()
        rvEpisodesList.layoutManager = LinearLayoutManager(requireContext())

        val viewModel = ViewModelProviders.of(this)
            .get(EpisodeViewModel::class.java)

        rvEpisodesList.adapter = adapter

        viewModel.episodePagedList.observe(requireActivity(), Observer {
            adapter.submitList(it)
        })

    }
}