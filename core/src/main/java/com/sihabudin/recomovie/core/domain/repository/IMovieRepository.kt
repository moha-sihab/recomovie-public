package com.sihabudin.recomovie.core.domain.repository

import com.sihabudin.recomovie.core.data.Resource
import com.sihabudin.recomovie.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {

    fun getMovie(): Flow<Resource<List<Movie>>>

    fun searchMovie(query: String): Flow<Resource<List<Movie>>>

    fun getFavoriteMovie(): Flow<List<Movie>>

    fun getTopRatedMovie(): Flow<Resource<List<Movie>>>

    fun getSingleMovie(id: Int): Flow<List<Movie>>

    fun getSingleFavoritMovie(id: Int): Flow<List<Movie>>

    fun getSingleSearchMovie(id: Int): Flow<List<Movie>>

    fun getSingleTopRatedMovie(id: Int): Flow<List<Movie>>

    fun insertFavoritMovie(movie: Movie)

    fun deleteFavoritMovie(movie: Movie)


}
