package com.dicoding.jetpack.jetpackmoviecataloguekotlin.utils

import com.dicoding.jetpack.jetpackmoviecataloguekotlin.data.MovieEntity
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.data.source.remote.response.MovieResponse
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.data.source.remote.response.TvShowResponse

interface MovieCallback {
    fun onFavoriteClick(movie: MovieEntity)
    fun onShareClick(movie: MovieEntity)
}

interface LoadMovieCallback {
    fun onAllMoviesReceived(movieResponses: List<MovieResponse>)
}

interface LoadTvShowCallback {
    fun onAllTvShowsReceived(tvShowResponses: List<TvShowResponse>)
}