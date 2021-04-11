package com.dicoding.jetpack.jetpackmoviecataloguekotlin.utils

import com.dicoding.jetpack.jetpackmoviecataloguekotlin.data.MovieEntity

interface MovieCallback {
    fun onFavoriteClick(movie: MovieEntity)
    fun onShareClick(movie: MovieEntity)
}