package com.example.nav_sample.app.di

import com.example.nav_sample.datasourse.CharacterDataSource
import org.koin.dsl.module

val dataSourceModule = module {
    single { CharacterDataSource(get()) }
}