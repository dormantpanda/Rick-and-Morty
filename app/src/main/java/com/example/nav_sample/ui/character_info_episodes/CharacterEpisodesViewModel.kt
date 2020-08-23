package com.example.nav_sample.ui.character_info_episodes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nav_sample.models.episodes.Episode
import com.example.nav_sample.network.repository.RemoteRepository

class CharacterEpisodesViewModel(
    val repository: RemoteRepository
) : ViewModel() {
    var screenState = MutableLiveData<List<Episode>>()

    fun loadEpisodes(episodeId : String){
       screenState.value = repository.getEpisodesById(episodeId)
    }
}