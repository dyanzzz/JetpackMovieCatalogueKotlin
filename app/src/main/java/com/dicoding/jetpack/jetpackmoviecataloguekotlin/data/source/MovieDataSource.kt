package com.dicoding.jetpack.jetpackmoviecataloguekotlin.data.source

import com.dicoding.jetpack.jetpackmoviecataloguekotlin.data.MovieEntity

interface MovieDataSource {
    fun getAllMovies(): List<MovieEntity>

    fun getAllTvShow(): List<MovieEntity>
}