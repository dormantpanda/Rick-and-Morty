package com.example.nav_sample.ui.locations

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.nav_sample.datasourse.LocationDataSource
import com.example.nav_sample.datasourse.LocationDataSourceFactory
import com.example.nav_sample.models.locations.Location

class LocationViewModel : ViewModel() {

    var locationPagedList : LiveData<PagedList<Location>>

    init {
        val itemDataSourceFactory = LocationDataSourceFactory()

        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(LocationDataSource.PAGE_SIZE)
            .build()

        locationPagedList = LivePagedListBuilder<Int, Location>(itemDataSourceFactory, config)
            .build()
    }
}