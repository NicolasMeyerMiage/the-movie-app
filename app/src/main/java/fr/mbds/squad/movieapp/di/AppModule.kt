package fr.mbds.squad.movieapp.di

import android.content.Context
import fr.mbds.squad.movieapp.ui.home.HomeViewModel
import fr.mbds.squad.movieapp.ui.movie.MovieViewModel
import fr.mbds.squad.movieapp.ui.tv.TvViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {
    single(named("API_KEY")) {
        "507a86e6d98ae2b2cd600e594ee02637"
    }

    single(named("BASE_URL")) {
        "https://api.themoviedb.org/3/"
    }

    single(named("APP_PREFS")) {
        androidContext().getSharedPreferences("app_private", Context.MODE_PRIVATE)
    }

    viewModel {
        HomeViewModel(repository = get())
    }

    viewModel {
        MovieViewModel(repository = get())
    }

    viewModel {
        TvViewModel(repository = get())
    }
}
