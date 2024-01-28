package com.example.movieapp.domain.use_case.get_movie_detail

import com.example.movieapp.data.remote.dto.MoviesDetailDto
import com.example.movieapp.data.remote.dto.toMovieDetail
import com.example.movieapp.data.remote.dto.toMovieList
import com.example.movieapp.domain.model.Movie
import com.example.movieapp.domain.model.MovieDetail
import com.example.movieapp.domain.repository.MovieRepository
import com.example.movieapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(
    val repository: MovieRepository
) {
    fun executeGetMovieDetails(imdbId :String) : Flow<Resource<MovieDetail>> = flow {
        try {
            emit(Resource.Loading())
            val movieDetail = repository.getMovieDetail(imdbId)
            emit(Resource.Success(movieDetail.toMovieDetail()))
        }catch (e:Exception) {
            emit(Resource.Error(e.localizedMessage))
        }
    }
}