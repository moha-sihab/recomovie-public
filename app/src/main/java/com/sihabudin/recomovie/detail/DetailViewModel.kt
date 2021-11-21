package com.sihabudin.recomovie.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.sihabudin.recomovie.core.domain.model.Movie
import com.sihabudin.recomovie.core.domain.usecase.MovieUseCase

class DetailViewModel(private val movieUseCase: MovieUseCase) : ViewModel() {
    fun getSingleFavoritMovie(id: Int) =
        movieUseCase.getSingleFavoritMovie(id).asLiveData()

    fun insertFavoriteMovie(movie: Movie) =
        movieUseCase.insertFavoritMovie(movie)

    fun deleteFavoriteMovie(movie: Movie) =
        movieUseCase.deleteFavoritMovie(movie)
}