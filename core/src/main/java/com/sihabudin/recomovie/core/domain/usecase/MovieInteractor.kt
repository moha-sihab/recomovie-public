package com.sihabudin.recomovie.core.domain.usecase

import com.sihabudin.recomovie.core.domain.model.Movie
import com.sihabudin.recomovie.core.domain.repository.IMovieRepository

class MovieInteractor(private val movieRepository: IMovieRepository) : MovieUseCase {

    override fun getMovie() = movieRepository.getMovie()

    override fun searchMovie(query: String) = movieRepository.searchMovie(query)

    override fun getFavoriteMovie() = movieRepository.getFavoriteMovie()

    override fun getTopRatedMovie() = movieRepository.getTopRatedMovie()

    override fun getSingleMovie(id: Int) = movieRepository.getSingleMovie(id)

    override fun getSingleFavoritMovie(id: Int) = movieRepository.getSingleFavoritMovie(id)

    override fun getSingleSearchMovie(id: Int) = movieRepository.getSingleSearchMovie(id)

    override fun getSingleTopRatedMovie(id: Int) = movieRepository.getSingleTopRatedMovie(id)

    override fun insertFavoritMovie(movie: Movie) = movieRepository.insertFavoritMovie(movie)

    override fun deleteFavoritMovie(movie: Movie) = movieRepository.deleteFavoritMovie(movie)
}