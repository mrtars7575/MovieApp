package com.example.movieapp.data.repository

import com.example.movieapp.data.remote.MoviesAPI
import com.example.movieapp.data.remote.dto.MoviesDetailDto
import com.example.movieapp.data.remote.dto.MoviesDto
import com.example.movieapp.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val api : MoviesAPI
) : MovieRepository {
    override suspend fun getMovies(search: String): MoviesDto {
        return api.getMovies(searchString = search)
    }

    override suspend fun getMovieDetail(imdbId: String): MoviesDetailDto {
        return api.getMovieDetail(imdbId = imdbId)
    }

}