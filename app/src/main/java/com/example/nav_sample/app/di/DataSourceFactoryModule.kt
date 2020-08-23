package com.example.nav_sample.app.di

import com.example.nav_sample.datasourse.CharacterDataSourceFactory
import org.koin.dsl.module

val dataSourceFactoryModule = module {
    single { CharacterDataSourceFactory(get()) }
}