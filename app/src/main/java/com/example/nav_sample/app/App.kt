package com.example.nav_sample.app

import android.app.Application
import com.example.nav_sample.app.di.networkModule
import com.example.nav_sample.app.di.repositoryModule
import com.example.nav_sample.app.di.roomModule
import com.example.nav_sample.app.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application(){

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(networkModule, repositoryModule, roomModule, viewModelModule))
        }
    }
}