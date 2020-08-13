package com.example.nav_sample.network

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient {

    companion object{
        val instance: ApiClient by lazy { ApiClient() }

        private const val BASE_URL = "https://rickandmortyapi.com/api/"
        private const val TIMEOUT: Long = 30
    }

    val mainApi: IMainApi = createRetrofit(createOkHttpClient()).create(IMainApi::class.java)

    fun createRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun createOkHttpClient(): OkHttpClient{
        val builder = OkHttpClient.Builder()
        builder.apply {
            readTimeout(TIMEOUT, TimeUnit.SECONDS)
            connectTimeout(TIMEOUT, TimeUnit.SECONDS)

            return builder.build()
        }
    }
}