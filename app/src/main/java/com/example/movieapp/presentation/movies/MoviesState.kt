package com.example.movieapp.presentation.movies

import com.example.movieapp.data.remote.dto.Search
import com.example.movieapp.domain.model.Movie

data class MoviesState(
    val isLoading : Boolean = false,
    val movies : List<Movie> = emptyList(),
    val error: String = "",
    val search: String = "batman"
) 