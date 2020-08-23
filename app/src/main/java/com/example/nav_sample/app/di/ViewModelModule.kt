package com.example.nav_sample.app.di

import com.example.nav_sample.ui.characters.CharacterViewModel
import com.example.nav_sample.ui.episodes.EpisodeViewModel
import com.example.nav_sample.ui.locations.LocationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { CharacterViewModel(get()) }
    viewModel { LocationViewModel(get()) }
    viewModel { EpisodeViewModel(get()) }
}