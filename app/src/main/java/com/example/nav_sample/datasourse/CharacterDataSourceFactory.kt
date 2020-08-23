package com.example.nav_sample.datasourse

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.nav_sample.models.characters.Character
import com.example.nav_sample.network.IMainApi
import com.example.nav_sample.network.repository.RemoteRepository

class CharacterDataSourceFactory(
    val repository: RemoteRepository
): DataSource.Factory<Int, Character>() {

    val characterLiveDataSource = MutableLiveData<CharacterDataSource>()

    override fun create(): DataSource<Int, Character> {
        val characterDataSource = CharacterDataSource(repository)
        characterLiveDataSource.postValue(characterDataSource)

        return characterDataSource
    }

}