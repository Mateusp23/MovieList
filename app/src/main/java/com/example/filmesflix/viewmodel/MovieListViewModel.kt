package com.example.filmesflix.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.filmesflix.api.MovieRestApiTask
import com.example.filmesflix.model.Movie
import com.example.filmesflix.repository.MovieRepository
import java.lang.Exception

class MovieListViewModel: ViewModel() {

    companion object{
        const val TAG = "MovieRepository"
    }

    private val movieRestApiTask = MovieRestApiTask()
    private val movieRepository = MovieRepository(movieRestApiTask)

    private var _movieList = MutableLiveData<List<Movie>>()
    val movieList: LiveData<List<Movie>>
    get() = _movieList

    fun init () {
        getAllMovies()
    }

    private fun getAllMovies() {
        Thread{
            try {
                _movieList.postValue(movieRepository.getAllMovies())
            } catch (exception: Exception) {
                Log.d(TAG, exception.message.toString())
            }
        }.start()
    }
}