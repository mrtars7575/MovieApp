package com.example.movieapp.domain.repository

import com.example.movieapp.data.remote.dto.MoviesDetailDto
import com.example.movieapp.data.remote.dto.MoviesDto

interface MovieRepository {

    suspend fun getMovies(search:String) :  MoviesDto
    suspend fun getMovieDetail(imdbId : String) : MoviesDetailDto

}