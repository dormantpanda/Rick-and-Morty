package com.example.nav_sample.ui.locations

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nav_sample.LocationListAdapter
import com.example.nav_sample.R
import kotlinx.android.synthetic.main.fragment_characters.*
import kotlinx.android.synthetic.main.fragment_locations.*

class LocationsFragment : Fragment(R.layout.fragment_locations) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = LocationListAdapter()
        rvLocationsList.layoutManager = LinearLayoutManager(requireContext())

        val viewModel = ViewModelProviders.of(this)
            .get(LocationViewModel::class.java)

        rvLocationsList.adapter = adapter

        viewModel.locationPagedList.observe(requireActivity(), Observer{
            adapter.submitList(it)
        })

    }
}