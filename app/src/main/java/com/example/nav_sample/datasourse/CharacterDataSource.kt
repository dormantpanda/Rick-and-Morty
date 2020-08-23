package com.example.nav_sample.datasourse

import androidx.paging.PageKeyedDataSource
import com.example.nav_sample.models.characters.Character
import com.example.nav_sample.network.ApiClient
import com.example.nav_sample.network.repository.RemoteRepository


class CharacterDataSource (
    val repository: RemoteRepository
): PageKeyedDataSource<Int, Character>() {
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Character>
    ) {
         val results = repository.getCharacters(FIRST_PAGE)
         callback.onResult(results , null, FIRST_PAGE + 1)

    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Character>) {
        val results = repository.getCharacters(params.key)
        callback.onResult(results ,params.key + 1)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Character>) {

    }

    companion object {
        const val PAGE_SIZE = 20
        const val FIRST_PAGE = 1
    }
}