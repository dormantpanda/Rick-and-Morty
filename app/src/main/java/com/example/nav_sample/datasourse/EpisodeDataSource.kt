package com.example.nav_sample.datasourse

import androidx.paging.PageKeyedDataSource
import com.example.nav_sample.models.episodes.Episode
import com.example.nav_sample.network.ApiClient
import com.example.nav_sample.network.repository.RemoteRepository

class EpisodeDataSource(
    val repository: RemoteRepository
) : PageKeyedDataSource<Int, Episode>() {
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Episode>
    ) {
        val results = repository.getEpisodes(FIRST_PAGE)
        callback.onResult(results , null, FIRST_PAGE + 1)
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Episode>) {
        val results = repository.getEpisodes(params.key)
        callback.onResult(results ,params.key + 1)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Episode>) {
    }

    companion object {
        const val PAGE_SIZE = 20
        const val FIRST_PAGE = 1
    }
}