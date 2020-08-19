package com.example.nav_sample.datasourse

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.nav_sample.models.episodes.Episode

class EpisodeDataSourceFactory : DataSource.Factory<Int, Episode>() {

    val episodeLiveDataSource = MutableLiveData<EpisodeDataSource>()

    override fun create(): DataSource<Int, Episode> {
        val episodeDataSource = EpisodeDataSource()
        episodeLiveDataSource.postValue(episodeDataSource)

        return episodeDataSource
    }
}