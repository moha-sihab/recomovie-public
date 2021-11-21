package com.sihabudin.recomovie.di

import com.sihabudin.recomovie.core.domain.usecase.MovieInteractor
import com.sihabudin.recomovie.core.domain.usecase.MovieUseCase
import com.sihabudin.recomovie.detail.DetailViewModel
import com.sihabudin.recomovie.home.HomeViewModel
import com.sihabudin.recomovie.search.SearchViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<MovieUseCase> { MovieInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailViewModel(get()) }
    viewModel { SearchViewModel(get()) }
}