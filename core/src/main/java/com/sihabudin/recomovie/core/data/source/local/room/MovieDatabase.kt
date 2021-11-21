package com.sihabudin.recomovie.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sihabudin.recomovie.core.data.source.local.entity.FavoritMovieEntity
import com.sihabudin.recomovie.core.data.source.local.entity.MovieEntity
import com.sihabudin.recomovie.core.data.source.local.entity.SearchMovieEntity
import com.sihabudin.recomovie.core.data.source.local.entity.TopRatedMovieEntity


@Database(
    entities = [MovieEntity::class, FavoritMovieEntity::class, SearchMovieEntity::class,TopRatedMovieEntity::class],
    version = 1,
    exportSchema = false
)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

}