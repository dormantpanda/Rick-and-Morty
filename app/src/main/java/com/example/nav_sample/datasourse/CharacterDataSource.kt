package com.example.nav_sample.datasourse

import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.example.nav_sample.models.characters.Character
import com.example.nav_sample.models.characters.CharacterResponse
import com.example.nav_sample.network.ApiClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharacterDataSource : PageKeyedDataSource<Int, Character>() {
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Character>
    ) {
        val apiClient = ApiClient.instance
        val call = apiClient.mainApi.getCharacters(FIRST_PAGE)

        call.subscribe({
            val results = it.results

            results?.let {
                callback.onResult(results , null, FIRST_PAGE + 1)
            }
        }, {

        })

//        call.enqueue(object : Callback<CharacterResponse>{
//            override fun onFailure(call: Call<CharacterResponse>, t: Throwable) {
//
//            }
//
//            override fun onResponse(
//                call: Call<CharacterResponse>,
//                response: Response<CharacterResponse>
//            ) {
//                if(response.isSuccessful){
//                    val apiResponse = response.body()!!
//                    val responseItems = apiResponse.results
//
//                    responseItems?.let {
//                        callback.onResult(responseItems, null, FIRST_PAGE + 1)
//                    }
//                }
//            }
//
//        })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Character>) {
//        val apiClient = ApiClient.instance
//        val call = apiClient.mainApi.getCharacters(params.key)
//
////        call.subscribe({
////            callback.onResult(it.results ?: emptyList(), params.key + 1)
////        }, {
////
////        })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Character>) {

    }

    companion object {
        const val PAGE_SIZE = 20
        const val FIRST_PAGE = 1
    }
}