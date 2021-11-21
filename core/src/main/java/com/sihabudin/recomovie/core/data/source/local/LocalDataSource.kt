package com.sihabudin.recomovie.core.data.source.local

import com.sihabudin.recomovie.core.data.source.local.entity.FavoritMovieEntity
import com.sihabudin.recomovie.core.data.source.local.entity.MovieEntity
import com.sihabudin.recomovie.core.data.source.local.entity.SearchMovieEntity
import com.sihabudin.recomovie.core.data.source.local.entity.TopRatedMovieEntity
import com.sihabudin.recomovie.core.data.source.local.room.MovieDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource constructor(private val movieDao: MovieDao) {

    fun getMovie(): Flow<List<MovieEntity>> = movieDao.getMovie()

    fun searchMovie(query: String): Flow<List<SearchMovieEntity>> = movieDao.searchMovie(query)

    fun getFavoriteMovie(): Flow<List<FavoritMovieEntity>> = movieDao.getFavoriteMovie()

    fun getTopRatedMovie(): Flow<List<TopRatedMovieEntity>> = movieDao.getTopRatedMovie()

    fun getSingleMovie(id: Int): Flow<List<MovieEntity>> = movieDao.getSingleMovie(id)

    fun getSingleFavoritMovie(id: Int): Flow<List<FavoritMovieEntity>> =
        movieDao.getSingleFavoriteMovie(id)

    fun getSingleSearchMovie(id: Int): Flow<List<SearchMovieEntity>> =
        movieDao.getSingleSearchMovie(id)

    fun getSingleTopRatedMovie(id: Int): Flow<List<TopRatedMovieEntity>> =
        movieDao.getSingleTopRatedMovie(id)

    suspend fun insertMovie(movieList: List<MovieEntity>) = movieDao.insertMovie(movieList)

    fun insertFavoritMovie(movieList: FavoritMovieEntity) = movieDao.insertFavoriteMovie(movieList)

    suspend fun insertSearchMovie(movieList: List<SearchMovieEntity>) = movieDao.insertSearchMovie(movieList)

    suspend fun insertTopRatedMovie(movieList: List<TopRatedMovieEntity>) = movieDao.insertTopRatedMovie(movieList)

    fun deleteFavoritMovie(movieList: FavoritMovieEntity) = movieDao.deleteFavoritMovie(movieList)

}