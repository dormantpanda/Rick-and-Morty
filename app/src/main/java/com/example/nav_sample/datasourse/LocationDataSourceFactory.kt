package com.example.nav_sample.datasourse

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.nav_sample.models.locations.Location

class LocationDataSourceFactory : DataSource.Factory<Int, Location>() {

    val locationLiveDataSource = MutableLiveData<LocationDataSource>()

    override fun create(): DataSource<Int, Location> {
        val locationDataSource = LocationDataSource()
        locationLiveDataSource.postValue(locationDataSource)

        return locationDataSource
    }
}