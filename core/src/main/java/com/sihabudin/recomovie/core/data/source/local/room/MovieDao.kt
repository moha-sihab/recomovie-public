package com.sihabudin.recomovie.core.data.source.local.room

import androidx.room.*
import com.sihabudin.recomovie.core.data.source.local.entity.FavoritMovieEntity
import com.sihabudin.recomovie.core.data.source.local.entity.MovieEntity
import com.sihabudin.recomovie.core.data.source.local.entity.SearchMovieEntity
import com.sihabudin.recomovie.core.data.source.local.entity.TopRatedMovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie")
    fun getMovie(): Flow<List<MovieEntity>>

    @Query("SELECT * FROM searchmovie where title LIKE '%' || :query || '%'")
    fun searchMovie(query: String): Flow<List<SearchMovieEntity>>

    @Query("SELECT * FROM favoritmovie")
    fun getFavoriteMovie(): Flow<List<FavoritMovieEntity>>

    @Query("SELECT * FROM topratedmovie")
    fun getTopRatedMovie(): Flow<List<TopRatedMovieEntity>>

    @Query("SELECT * FROM movie where id=:id")
    fun getSingleMovie(id: Int): Flow<List<MovieEntity>>

    @Query("SELECT * FROM favoritmovie where id=:id")
    fun getSingleFavoriteMovie(id: Int): Flow<List<FavoritMovieEntity>>

    @Query("SELECT * FROM searchmovie where id=:id")
    fun getSingleSearchMovie(id: Int): Flow<List<SearchMovieEntity>>

    @Query("SELECT * FROM topratedmovie where id=:id")
    fun getSingleTopRatedMovie(id: Int): Flow<List<TopRatedMovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie: List<MovieEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavoriteMovie(movie: FavoritMovieEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSearchMovie(movie: List<SearchMovieEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTopRatedMovie(movie: List<TopRatedMovieEntity>)

    @Delete
    fun deleteFavoritMovie(movie: FavoritMovieEntity)
}