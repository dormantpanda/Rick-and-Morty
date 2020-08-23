package com.example.nav_sample.network.repository

import android.util.Log
import com.example.nav_sample.datasourse.CharacterDataSource
import com.example.nav_sample.models.characters.Character
import com.example.nav_sample.models.episodes.Episode
import com.example.nav_sample.models.locations.Location
import com.example.nav_sample.network.ApiClient
import com.example.nav_sample.network.IMainApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

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

    fun getEpisodesById(path: String) : List<Episode>{
        val call = ApiClient.instance.mainApi.getEpisodesById(path)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

        var results : List<Episode>? = null
        call.subscribe({
            results = it
        }, {
            Log.d("666-666", it.stackTrace.toString())
        })
        results?.let {
            return it
        }
        return listOf()
    }
}