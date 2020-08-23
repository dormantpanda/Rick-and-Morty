package com.example.nav_sample.datasourse

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.nav_sample.models.locations.Location
import com.example.nav_sample.network.repository.RemoteRepository

class LocationDataSourceFactory(
    val repository: RemoteRepository
) : DataSource.Factory<Int, Location>() {

    val locationLiveDataSource = MutableLiveData<LocationDataSource>()

    override fun create(): DataSource<Int, Location> {
        val locationDataSource = LocationDataSource(repository)
        locationLiveDataSource.postValue(locationDataSource)

        return locationDataSource
    }
}