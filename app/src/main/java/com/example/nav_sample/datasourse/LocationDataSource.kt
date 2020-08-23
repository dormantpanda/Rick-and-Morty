package com.example.nav_sample.datasourse

import androidx.paging.PageKeyedDataSource
import com.example.nav_sample.models.locations.Location
import com.example.nav_sample.network.ApiClient
import com.example.nav_sample.network.repository.RemoteRepository

class LocationDataSource(
    val repository: RemoteRepository
) : PageKeyedDataSource<Int, Location>() {
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Location>
    ) {
        val results = repository.getLocations(FIRST_PAGE)
        callback.onResult(results, null, FIRST_PAGE + 1)
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Location>) {
        val results = repository.getLocations(params.key)
        callback.onResult(results, params.key + 1)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Location>) {

    }

    companion object {
        const val PAGE_SIZE = 20
        const val FIRST_PAGE = 1
    }
}