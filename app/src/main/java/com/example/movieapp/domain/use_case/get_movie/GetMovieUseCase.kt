package com.example.movieapp.domain.use_case.get_movie

import com.example.movieapp.data.remote.dto.toMovieList
import com.example.movieapp.domain.model.Movie
import com.example.movieapp.domain.repository.MovieRepository
import com.example.movieapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(
    val repository: MovieRepository
) {
    fun executeGetMovies(search :String) : Flow<Resource<List<Movie>>> = flow {
        try {
            emit(Resource.Loading())
            val movieList =  repository.getMovies(search)
            if (movieList.Response.equals("True")){
                emit(Resource.Success(movieList.toMovieList()))
            }else{
                emit(Resource.Error("No movie found"))
                println("no movie found")
            }
        }catch (e:Exception) {
            emit(Resource.Error(e.localizedMessage))
            println("error : "+ e.localizedMessage)
        }
    }
}