package com.example.nav_sample.ui.characters

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.nav_sample.datasourse.CharacterDataSource
import com.example.nav_sample.datasourse.CharacterDataSourceFactory
import com.example.nav_sample.models.characters.Character
import com.example.nav_sample.network.ApiClient
import com.example.nav_sample.network.IMainApi
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class CharacterViewModel() : ViewModel() {

    var characterPagedList : LiveData<PagedList<Character>>

//    private val liveDataSource : MutableLiveData<CharacterDataSource>

    init {
        val itemDataSourceFactory = CharacterDataSourceFactory()

//        liveDataSource = itemDataSourceFactory.characterLiveDataSource

        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(CharacterDataSource.PAGE_SIZE)
            .build()

        characterPagedList = LivePagedListBuilder<Int, Character>(itemDataSourceFactory, config)
            .build()
    }

//    val screenState = MutableLiveData<CharacterState>()
//
//    fun loadCharacters() {
//        getCharacters()
//            .doOnNext {
//                screenState.value =
//                    CharacterState.StateLoading
//            }
//            .subscribe({
//                screenState.value =
//                    CharacterState.StateShowCharacters(it)
//            }, {
//                screenState.value =
//                    CharacterState.StateError(it.message!!)
//            })
//    }
//
//    fun getCharacters(): Observable<List<Character>> {
//        return ApiClient.instance.mainApi.getCharacters()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .flatMap {
//                Observable.just(it.results)
//            }
//    }
}