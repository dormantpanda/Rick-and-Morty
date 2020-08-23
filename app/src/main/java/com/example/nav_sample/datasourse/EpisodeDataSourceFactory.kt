package com.example.nav_sample.datasourse

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.nav_sample.models.episodes.Episode
import com.example.nav_sample.network.repository.RemoteRepository

class EpisodeDataSourceFactory(
    val repository: RemoteRepository
) : DataSource.Factory<Int, Episode>() {

    val episodeLiveDataSource = MutableLiveData<EpisodeDataSource>()

    override fun create(): DataSource<Int, Episode> {
        val episodeDataSource = EpisodeDataSource(repository)
        episodeLiveDataSource.postValue(episodeDataSource)

        return episodeDataSource
    }
}