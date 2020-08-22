package com.example.nav_sample.app.di

import com.example.nav_sample.cache.db.LocalDatabase
import org.koin.dsl.module

val roomModule = module {
    single { LocalDatabase.buildDataSource(get()) }
}