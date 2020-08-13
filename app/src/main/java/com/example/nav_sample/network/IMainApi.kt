package com.example.nav_sample.network

import com.example.nav_sample.models.characters.CharacterResponse
import com.example.nav_sample.models.episodes.EpisodeResponse
import com.example.nav_sample.models.locations.LocationResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface IMainApi {

    @GET(CHARACTERS_PATH)
    fun getCharacters(): Observable<CharacterResponse>

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