package com.sihabudin.recomovie.core.data

import com.sihabudin.recomovie.core.data.source.local.LocalDataSource
import com.sihabudin.recomovie.core.data.source.remote.RemoteDataSource
import com.sihabudin.recomovie.core.data.source.remote.network.ApiResponse
import com.sihabudin.recomovie.core.data.source.remote.response.MovieResponse
import com.sihabudin.recomovie.core.domain.model.Movie
import com.sihabudin.recomovie.core.domain.repository.IMovieRepository
import com.sihabudin.recomovie.core.utils.AppExecutors
import com.sihabudin.recomovie.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MovieRepository constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IMovieRepository {


    override fun getMovie(): Flow<Resource<List<Movie>>> =
        object : NetworkBoundResource<List<Movie>, List<MovieResponse>>() {
            override fun loadFromDB(): Flow<List<Movie>> {
                return localDataSource.getMovie().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Movie>?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getMovie()

            override suspend fun saveCallResult(data: List<MovieResponse>) {
                val movieList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertMovie(movieList)
            }
        }.asFlow()

    override fun searchMovie(query: String): Flow<Resource<List<Movie>>> =
        object : NetworkBoundResource<List<Movie>, List<MovieResponse>>() {
            override fun loadFromDB(): Flow<List<Movie>> {
                return localDataSource.searchMovie(query).map {
                    DataMapper.mapSearchEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Movie>?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.searchMovie(query)

            override suspend fun saveCallResult(data: List<MovieResponse>) {
                val movieList = DataMapper.mapResponsesToSearchEntities(data)
                localDataSource.insertSearchMovie(movieList)
            }

        }.asFlow()

    override fun getTopRatedMovie(): Flow<Resource<List<Movie>>> =
        object : NetworkBoundResource<List<Movie>, List<MovieResponse>>() {
            override fun loadFromDB(): Flow<List<Movie>> {
                return localDataSource.getTopRatedMovie().map {
                    DataMapper.mapTopRatedEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Movie>?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getMovieTopRated()

            override suspend fun saveCallResult(data: List<MovieResponse>) {
                val movieList = DataMapper.mapResponsesToTopRatedEntities(data)
                localDataSource.insertTopRatedMovie(movieList)
            }
        }.asFlow()

    override fun getFavoriteMovie(): Flow<List<Movie>> {

        return localDataSource.getFavoriteMovie().map {
            DataMapper.mapFavoritEntitiesToDomain(it)
        }
    }

    override fun getSingleMovie(id: Int): Flow<List<Movie>> {

        return localDataSource.getSingleMovie(id).map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun getSingleTopRatedMovie(id: Int): Flow<List<Movie>> {

        return localDataSource.getSingleTopRatedMovie(id).map {
            DataMapper.mapTopRatedEntitiesToDomain(it)
        }
    }

    override fun getSingleSearchMovie(id: Int): Flow<List<Movie>> {

        return localDataSource.getSingleSearchMovie(id).map {
            DataMapper.mapSearchEntitiesToDomain(it)
        }
    }

    override fun getSingleFavoritMovie(id: Int): Flow<List<Movie>> {

        return localDataSource.getSingleFavoritMovie(id).map {
            DataMapper.mapFavoritEntitiesToDomain(it)
        }
    }

    override fun insertFavoritMovie(movie: Movie) {
        val movieEntity = DataMapper.mapDomainToFavoritEntity(movie)
        appExecutors.diskIO().execute { localDataSource.insertFavoritMovie(movieEntity) }
    }



    override fun deleteFavoritMovie(movie: Movie) {
        val movieEntity = DataMapper.mapDomainToFavoritEntity(movie)
        appExecutors.diskIO().execute { localDataSource.deleteFavoritMovie(movieEntity) }
    }
}
