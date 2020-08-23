package com.example.nav_sample.ui.episodes

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.nav_sample.datasourse.EpisodeDataSource
import com.example.nav_sample.datasourse.EpisodeDataSourceFactory
import com.example.nav_sample.models.episodes.Episode
import com.example.nav_sample.network.repository.RemoteRepository

class EpisodeViewModel(
    val repository: RemoteRepository
) : ViewModel() {

    var episodePagedList : LiveData<PagedList<Episode>>

    init {
        val itemDataSourceFactory = EpisodeDataSourceFactory(repository)

        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(EpisodeDataSource.PAGE_SIZE)
            .build()

        episodePagedList = LivePagedListBuilder<Int, Episode>(itemDataSourceFactory, config)
            .build()
    }
}