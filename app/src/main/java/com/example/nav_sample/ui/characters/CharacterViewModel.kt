package com.example.nav_sample.ui.characters

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.nav_sample.datasourse.CharacterDataSource
import com.example.nav_sample.datasourse.CharacterDataSourceFactory
import com.example.nav_sample.models.characters.Character
import com.example.nav_sample.network.repository.RemoteRepository


class CharacterViewModel(
    repository: RemoteRepository
) : ViewModel() {

    var characterPagedList : LiveData<PagedList<Character>>

    init {
        val itemDataSourceFactory = CharacterDataSourceFactory(repository)

        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(CharacterDataSource.PAGE_SIZE)
            .build()

        characterPagedList = LivePagedListBuilder<Int, Character>(itemDataSourceFactory, config)
            .build()
    }
}