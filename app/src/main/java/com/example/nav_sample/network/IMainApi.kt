package com.example.nav_sample.network

import com.example.nav_sample.models.characters.CharacterResponse
import com.example.nav_sample.models.episodes.EpisodeResponse
import com.example.nav_sample.models.locations.LocationResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IMainApi {

    @GET(CHARACTERS_PATH)
    fun getCharacters(@Query("page") page : Int): Single<CharacterResponse>

    @GET(LOCATIONS_PATH)
    fun getLocations(): Observable<LocationResponse>

    @GET(EPISODES_PATH)
    fun getEpisodes(): Observable<EpisodeResponse>

    companion object{
        const val CHARACTERS_PATH = "character/"
        const val LOCATIONS_PATH = "location/"
        const val EPISODES_PATH = "episode/"
    }
}