package com.dicoding.jetpack.jetpackmoviecataloguekotlin.data.source.remote

import com.dicoding.jetpack.jetpackmoviecataloguekotlin.data.source.remote.response.MovieResponse
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.data.source.remote.response.TvShowResponse
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {
    companion object{
        @Volatile
        private var instance: RemoteDataSource? = null
        fun getInstance(helper: JsonHelper): RemoteDataSource = instance ?: synchronized(this) {
            instance ?: RemoteDataSource(helper).apply {
                instance = this
            }
        }
    }

    fun getAllMovies(): List<MovieResponse> = jsonHelper.loadMovies()

    fun getAllTvShow(): List<TvShowResponse> = jsonHelper.loadTvShows()
}
