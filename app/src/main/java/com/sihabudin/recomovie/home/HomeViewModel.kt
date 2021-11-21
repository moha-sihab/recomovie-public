package com.sihabudin.recomovie.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.sihabudin.recomovie.core.domain.usecase.MovieUseCase

class HomeViewModel(private val movieUseCase: MovieUseCase) : ViewModel() {
    val movie = movieUseCase.getMovie().asLiveData()
    val topRatedMovie = movieUseCase.getTopRatedMovie().asLiveData()
}
