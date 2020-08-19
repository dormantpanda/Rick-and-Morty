package com.example.nav_sample.datasourse

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.nav_sample.models.characters.Character

class CharacterDataSourceFactory : DataSource.Factory<Int, Character>() {

    val characterLiveDataSource = MutableLiveData<CharacterDataSource>()

    override fun create(): DataSource<Int, Character> {
        val characterDataSource = CharacterDataSource()
        characterLiveDataSource.postValue(characterDataSource)

        return characterDataSource
    }

}