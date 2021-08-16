package com.example.filmesflix.framework.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.filmesflix.framework.api.MovieRestApiTask
import com.example.filmesflix.data.MovieRepository
import com.example.filmesflix.domain.Movie
import com.example.filmesflix.implementations.MoviesDataSourceImplementation
import com.example.filmesflix.usecase.MoviesListUseCase
import java.lang.Exception

class MovieListViewModel: ViewModel() {

    companion object{
        const val TAG = "MovieRepository"
    }

    private val movieRestApiTask = MovieRestApiTask()
    private val movieDataSource = MoviesDataSourceImplementation(movieRestApiTask)
    private val movieRepository = MovieRepository(movieDataSource)
    private val moviesListUseCase = MoviesListUseCase(movieRepository)

    private var _movieList = MutableLiveData<List<Movie>>()
    val movieList: LiveData<List<Movie>>
    get() = _movieList

    fun init () {
        getAllMovies()
    }

    private fun getAllMovies() {
        Thread{
            try {
                _movieList.postValue(moviesListUseCase.invoke())
            } catch (exception: Exception) {
                Log.d(TAG, exception.message.toString())
            }
        }.start()
    }
}