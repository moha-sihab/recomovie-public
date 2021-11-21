package com.sihabudin.recomovie.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.sihabudin.recomovie.core.domain.usecase.MovieUseCase

class FavoriteViewModel(movieUseCase: MovieUseCase) : ViewModel() {
    val movie = movieUseCase.getFavoriteMovie().asLiveData()
}
