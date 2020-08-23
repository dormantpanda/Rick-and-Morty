package com.example.nav_sample.app.di

import com.example.nav_sample.network.IMainApi
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single { createOkHttpClient() }
    single { createRetrofit(get()) }
    single { createMainApi(get()) }
}

private fun createMainApi(retrofit: Retrofit) : IMainApi {
    return retrofit.create(IMainApi::class.java)
}

private const val BASE_URL = "https://rickandmortyapi.com/api/"
private const val TIMEOUT: Long = 30

fun createOkHttpClient(): OkHttpClient {
    val logging : HttpLoggingInterceptor = HttpLoggingInterceptor()
    logging.setLevel(HttpLoggingInterceptor.Level.BODY)

    val builder = OkHttpClient.Builder()
    builder.apply {
        readTimeout(TIMEOUT, TimeUnit.SECONDS)
        connectTimeout(TIMEOUT, TimeUnit.SECONDS)

        addInterceptor(logging)
        return builder.build()
    }
}

fun createRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}