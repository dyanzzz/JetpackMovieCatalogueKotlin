package com.dicoding.jetpack.jetpackmoviecataloguekotlin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.data.MovieEntity
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.data.source.MovieRepository
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.utils.DataDummy

class MovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    //fun getMovies() : List<MovieEntity> = DataDummy.generateDummyMovie("movie")
    //fun getMovies() : List<MovieEntity> = movieRepository.getAllMovies()
    fun getMovies() : LiveData<List<MovieEntity>> = movieRepository.getAllMovies()
}