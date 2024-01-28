package com.example.movieapp.data.remote

import com.example.movieapp.data.remote.dto.MoviesDetailDto
import com.example.movieapp.data.remote.dto.MoviesDto
import com.example.movieapp.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesAPI {

    //https://www.omdbapi.com/?s=batman&apikey=6d4164bb
    //https://www.omdbapi.com/?&apikey=6d4164bb&i=tt0372784
    @GET(".")
    suspend fun getMovies(
        @Query("s") searchString : String,
        @Query("apikey") apiKey : String = API_KEY
    ) : MoviesDto

    @GET(".")
    suspend fun getMovieDetail(
        @Query("i") imdbId : String,
        @Query("apikey") apiKey : String = API_KEY
    ):MoviesDetailDto

}