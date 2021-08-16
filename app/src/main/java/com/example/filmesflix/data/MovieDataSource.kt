package com.example.filmesflix.data

import com.example.filmesflix.domain.Movie

interface MovieDataSource {
    fun getAllMovies(): List<Movie>
}