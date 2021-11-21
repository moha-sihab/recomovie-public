package com.sihabudin.recomovie.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.sihabudin.recomovie.core.domain.usecase.MovieUseCase

class SearchViewModel(private val movieUseCase: MovieUseCase) : ViewModel() {
    fun searchMovie(query: String) = movieUseCase.searchMovie(query).asLiveData()
}