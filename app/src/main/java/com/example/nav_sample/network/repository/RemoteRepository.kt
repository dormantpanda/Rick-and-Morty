package com.example.nav_sample.network.repository

import com.example.nav_sample.datasourse.CharacterDataSource
import com.example.nav_sample.models.characters.Character
import com.example.nav_sample.models.episodes.Episode
import com.example.nav_sample.models.locations.Location
import com.example.nav_sample.network.ApiClient
import com.example.nav_sample.network.IMainApi

class RemoteRepository(
    val api : IMainApi
) {

    fun getCharacters(page: Int) : List<Character>{
        val call = api.getCharacters(page)

        var results : List<Character>? = null
        call.subscribe({
            results = it.results
        }, {

        })
        results?.let {
            return it
        }
        return listOf()
    }

    fun getLocations(page: Int) : List<Location>{
        val call = api.getLocations(page)

        var results : List<Location>? = null
        call.subscribe({
            results = it.results
        }, {

        })
        results?.let {
            return it
        }
        return listOf()
    }

    fun getEpisodes(page: Int) : List<Episode>{
        val call = api.getEpisodes(page)

        var results : List<Episode>? = null
        call.subscribe({
            results = it.results
        }, {

        })
        results?.let {
            return it
        }
        return listOf()
    }
}