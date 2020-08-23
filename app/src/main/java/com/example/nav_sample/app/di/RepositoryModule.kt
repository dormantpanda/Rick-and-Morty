package com.example.nav_sample.app.di

import com.example.nav_sample.network.repository.RemoteRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { RemoteRepository(get()) }
}