package com.sihabudin.recomovie.core.data.source.remote.network

import com.sihabudin.recomovie.core.data.source.remote.response.ListMovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("movie/popular")
    suspend fun getMovie(
        @Query("api_key") apiKey: String,
        @Query("page") page: String
    ): ListMovieResponse

    @GET("movie/top_rated")
    suspend fun getMovieTopRated(
        @Query("api_key") apiKey: String,
        @Query("page") page: String
    ): ListMovieResponse

    @GET("search/movie")
    suspend fun searchMovie(
        @Query("api_key") apiKey: String,
        @Query("query") query: String,
        @Query("page") page: String
    ): ListMovieResponse


}