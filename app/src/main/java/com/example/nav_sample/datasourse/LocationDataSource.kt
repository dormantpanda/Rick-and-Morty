package com.example.nav_sample.datasourse

import androidx.paging.PageKeyedDataSource
import com.example.nav_sample.models.locations.Location
import com.example.nav_sample.network.ApiClient

class LocationDataSource : PageKeyedDataSource<Int, Location>() {
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Location>
    ) {
        val apiClient = ApiClient.instance
        val call = apiClient.mainApi.getLocations(FIRST_PAGE)

        call.subscribe({
            val results = it.results

            results?.let {
                callback.onResult(results , null, FIRST_PAGE + 1)
            }
        }, {

        })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Location>) {
        val apiClient = ApiClient.instance
        val call = apiClient.mainApi.getLocations(params.key)

        call.subscribe({
            val results = it.results

            results?.let {
                callback.onResult(results, params.key + 1)
            }
        }, {

        })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Location>) {

    }

    companion object {
        const val PAGE_SIZE = 20
        const val FIRST_PAGE = 1
    }
}