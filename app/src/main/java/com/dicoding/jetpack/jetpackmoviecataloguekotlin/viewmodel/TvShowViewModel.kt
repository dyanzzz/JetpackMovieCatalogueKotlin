package com.dicoding.jetpack.jetpackmoviecataloguekotlin.viewmodel

import androidx.lifecycle.ViewModel
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.data.MovieEntity
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.utils.DataDummy

class TvShowViewModel : ViewModel() {
    fun getTvShow() : List<MovieEntity> = DataDummy.generateDummyMovie("tv")
}