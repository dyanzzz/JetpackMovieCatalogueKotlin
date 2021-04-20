package com.dicoding.jetpack.jetpackmoviecataloguekotlin.data.source

import androidx.lifecycle.LiveData
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.data.MovieEntity

interface MovieDataSource {
    // fun getAllMoviesOld(): List<MovieEntity>
    fun getAllMovies(): LiveData<List<MovieEntity>>

    // fun getAllTvShowOld(): List<MovieEntity>
    fun getAllTvShow(): LiveData<List<MovieEntity>>
}