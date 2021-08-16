package com.example.filmesflix.api

import com.example.filmesflix.model.Movie
import retrofit2.Call
import retrofit2.http.GET

interface MovieApi {
    //https://raw.githubusercontent.com/natanfelipe/FilmesFlixJson/master/moviesList
    @GET("natanfelipe/FilmesFlixJson/master/moviesList")
    fun getAllMovies() : Call<List<Movie>>
}