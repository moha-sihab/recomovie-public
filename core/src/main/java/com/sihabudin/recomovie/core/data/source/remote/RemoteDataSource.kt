package com.sihabudin.recomovie.core.data.source.remote


import android.util.Log
import com.sihabudin.recomovie.core.BuildConfig
import com.sihabudin.recomovie.core.data.source.remote.network.ApiResponse
import com.sihabudin.recomovie.core.data.source.remote.network.ApiService
import com.sihabudin.recomovie.core.data.source.remote.response.MovieResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource constructor(private val apiService: ApiService) {

    suspend fun getMovie(): Flow<ApiResponse<List<MovieResponse>>> {

        return flow {
            try {
                val response = apiService.getMovie(BuildConfig.API_KEY, "1")
                val dataArray = response.results
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)

    }

    suspend fun getMovieTopRated(): Flow<ApiResponse<List<MovieResponse>>> {

        return flow {
            try {
                val response = apiService.getMovieTopRated(BuildConfig.API_KEY, "1")
                val dataArray = response.results
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)

    }

    suspend fun searchMovie(query: String): Flow<ApiResponse<List<MovieResponse>>> {

        return flow {
            try {
                val response = apiService.searchMovie(BuildConfig.API_KEY, query, "1")
                val dataArray = response.results
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)


    }
}
