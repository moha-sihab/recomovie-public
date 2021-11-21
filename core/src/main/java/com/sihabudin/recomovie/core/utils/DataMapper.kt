package com.sihabudin.recomovie.core.utils

import com.sihabudin.recomovie.core.BuildConfig
import com.sihabudin.recomovie.core.data.source.local.entity.FavoritMovieEntity
import com.sihabudin.recomovie.core.data.source.local.entity.MovieEntity
import com.sihabudin.recomovie.core.data.source.local.entity.SearchMovieEntity
import com.sihabudin.recomovie.core.data.source.local.entity.TopRatedMovieEntity
import com.sihabudin.recomovie.core.data.source.remote.response.MovieResponse
import com.sihabudin.recomovie.core.domain.model.Movie

object DataMapper {
    fun mapResponsesToEntities(input: List<MovieResponse>): List<MovieEntity> {
        val movieList = ArrayList<MovieEntity>()
        input.map {
            val movies = MovieEntity(
                id = it.id,
                overview = it.overview,
                originalLanguage = it.originalLanguage,
                originalTitle = it.originalTitle,
                video = it.video,
                title = it.title,
                posterPath = BuildConfig.IMAGE_URL + it.posterPath,
                backdropPath = BuildConfig.IMAGE_URL + it.backdropPath,
                releaseDate = it.releaseDate,
                popularity = it.popularity,
                voteAverage = it.voteAverage,
                adult = it.adult,
                voteCount = it.voteCount
            )
            movieList.add(movies)
        }
        return movieList
    }

    fun mapEntitiesToDomain(input: List<MovieEntity>): List<Movie> =
        input.map {
            Movie(
                id = it.id,
                overview = it.overview,
                originalLanguage = it.originalLanguage,
                originalTitle = it.originalTitle,
                video = it.video,
                title = it.title,
                posterPath = it.posterPath,
                backdropPath = it.backdropPath,
                releaseDate = it.releaseDate,
                popularity = it.popularity,
                voteAverage = it.voteAverage,
                adult = it.adult,
                voteCount = it.voteCount
            )
        }

    fun mapDomainToEntity(input: Movie) = MovieEntity(
        id = input.id,
        overview = input.overview,
        originalLanguage = input.originalLanguage,
        originalTitle = input.originalTitle,
        video = input.video,
        title = input.title,
        posterPath = input.posterPath,
        backdropPath = input.backdropPath,
        releaseDate = input.releaseDate,
        popularity = input.popularity,
        voteAverage = input.voteAverage,
        adult = input.adult,
        voteCount = input.voteCount
    )

    fun mapFavoritEntitiesToDomain(input: List<FavoritMovieEntity>): List<Movie> =
        input.map {
            Movie(
                id = it.id,
                overview = it.overview,
                originalLanguage = it.originalLanguage,
                originalTitle = it.originalTitle,
                video = it.video,
                title = it.title,
                posterPath = it.posterPath,
                backdropPath = it.backdropPath,
                releaseDate = it.releaseDate,
                popularity = it.popularity,
                voteAverage = it.voteAverage,
                adult = it.adult,
                voteCount = it.voteCount
            )
        }

    fun mapDomainToFavoritEntity(input: Movie) = FavoritMovieEntity(
        id = input.id,
        overview = input.overview,
        originalLanguage = input.originalLanguage,
        originalTitle = input.originalTitle,
        video = input.video,
        title = input.title,
        posterPath = input.posterPath,
        backdropPath = input.backdropPath,
        releaseDate = input.releaseDate,
        popularity = input.popularity,
        voteAverage = input.voteAverage,
        adult = input.adult,
        voteCount = input.voteCount
    )


    fun mapResponsesToSearchEntities(input: List<MovieResponse>): List<SearchMovieEntity> {
        val movieList = ArrayList<SearchMovieEntity>()
        input.map {
            val movies = SearchMovieEntity(
                id = it.id,
                overview = it.overview,
                originalLanguage = it.originalLanguage,
                originalTitle = it.originalTitle,
                video = it.video,
                title = it.title,
                posterPath = BuildConfig.IMAGE_URL + it.posterPath,
                backdropPath = BuildConfig.IMAGE_URL + it.backdropPath,
                releaseDate = it.releaseDate,
                popularity = it.popularity,
                voteAverage = it.voteAverage,
                adult = it.adult,
                voteCount = it.voteCount
            )
            movieList.add(movies)
        }
        return movieList
    }

    fun mapSearchEntitiesToDomain(input: List<SearchMovieEntity>): List<Movie> =
        input.map {
            Movie(
                id = it.id,
                overview = it.overview,
                originalLanguage = it.originalLanguage,
                originalTitle = it.originalTitle,
                video = it.video,
                title = it.title,
                posterPath = it.posterPath,
                backdropPath = it.backdropPath,
                releaseDate = it.releaseDate,
                popularity = it.popularity,
                voteAverage = it.voteAverage,
                adult = it.adult,
                voteCount = it.voteCount
            )
        }

    fun mapDomainToSearchEntity(input: Movie) = SearchMovieEntity(
        id = input.id,
        overview = input.overview,
        originalLanguage = input.originalLanguage,
        originalTitle = input.originalTitle,
        video = input.video,
        title = input.title,
        posterPath = input.posterPath,
        backdropPath = input.backdropPath,
        releaseDate = input.releaseDate,
        popularity = input.popularity,
        voteAverage = input.voteAverage,
        adult = input.adult,
        voteCount = input.voteCount
    )

    fun mapResponsesToTopRatedEntities(input: List<MovieResponse>): List<TopRatedMovieEntity> {
        val movieList = ArrayList<TopRatedMovieEntity>()
        input.map {
            val movies = TopRatedMovieEntity(
                id = it.id,
                overview = it.overview,
                originalLanguage = it.originalLanguage,
                originalTitle = it.originalTitle,
                video = it.video,
                title = it.title,
                posterPath = BuildConfig.IMAGE_URL + it.posterPath,
                backdropPath = BuildConfig.IMAGE_URL + it.backdropPath,
                releaseDate = it.releaseDate,
                popularity = it.popularity,
                voteAverage = it.voteAverage,
                adult = it.adult,
                voteCount = it.voteCount
            )
            movieList.add(movies)
        }
        return movieList
    }

    fun mapTopRatedEntitiesToDomain(input: List<TopRatedMovieEntity>): List<Movie> =
        input.map {
            Movie(
                id = it.id,
                overview = it.overview,
                originalLanguage = it.originalLanguage,
                originalTitle = it.originalTitle,
                video = it.video,
                title = it.title,
                posterPath = it.posterPath,
                backdropPath = it.backdropPath,
                releaseDate = it.releaseDate,
                popularity = it.popularity,
                voteAverage = it.voteAverage,
                adult = it.adult,
                voteCount = it.voteCount
            )
        }

    fun mapDomainToTopRatedEntity(input: Movie) = TopRatedMovieEntity(
        id = input.id,
        overview = input.overview,
        originalLanguage = input.originalLanguage,
        originalTitle = input.originalTitle,
        video = input.video,
        title = input.title,
        posterPath = input.posterPath,
        backdropPath = input.backdropPath,
        releaseDate = input.releaseDate,
        popularity = input.popularity,
        voteAverage = input.voteAverage,
        adult = input.adult,
        voteCount = input.voteCount
    )
}