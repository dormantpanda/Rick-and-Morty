package com.example.nav_sample.datasourse

import androidx.paging.PageKeyedDataSource
import com.example.nav_sample.models.episodes.Episode
import com.example.nav_sample.network.ApiClient

class EpisodeDataSource : PageKeyedDataSource<Int, Episode>() {
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Episode>
    ) {
        val apiClient = ApiClient.instance
        val call = apiClient.mainApi.getEpisodes(FIRST_PAGE)

        call.subscribe({
            val results = it.results

            results?.let {
                callback.onResult(results , null, FIRST_PAGE + 1)
            }
        }, {

        })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Episode>) {
        val apiClient = ApiClient.instance
        val call = apiClient.mainApi.getEpisodes(params.key)

        call.subscribe({
            val results = it.results

            results?.let {
                callback.onResult(results,  params.key + 1)
            }
        }, {

        })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Episode>) {
    }

    companion object {
        const val PAGE_SIZE = 20
        const val FIRST_PAGE = 1
    }
}