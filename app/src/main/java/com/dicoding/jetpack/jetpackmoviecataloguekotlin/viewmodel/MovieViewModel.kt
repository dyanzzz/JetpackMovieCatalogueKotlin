package com.dicoding.jetpack.jetpackmoviecataloguekotlin.viewmodel

import androidx.lifecycle.ViewModel
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.data.MovieEntity
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.utils.DataDummy

class MovieViewModel : ViewModel() {
    fun getMovies() : List<MovieEntity> = DataDummy.generateDummyMovie("movie")
}