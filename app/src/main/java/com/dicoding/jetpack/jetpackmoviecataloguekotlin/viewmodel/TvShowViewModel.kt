package com.dicoding.jetpack.jetpackmoviecataloguekotlin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.data.MovieEntity
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.data.source.MovieRepository
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.utils.DataDummy

class TvShowViewModel(private val tvShowRepository: MovieRepository) : ViewModel() {
    //fun getTvShow() : List<MovieEntity> = DataDummy.generateDummyMovie("tv")
    //fun getTvShow() : List<MovieEntity> = tvShowRepository.getAllTvShow()
    fun getTvShow() : LiveData<List<MovieEntity>> = tvShowRepository.getAllTvShow()
}