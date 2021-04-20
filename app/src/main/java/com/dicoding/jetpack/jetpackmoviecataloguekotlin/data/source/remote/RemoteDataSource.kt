package com.dicoding.jetpack.jetpackmoviecataloguekotlin.data.source.remote

import android.os.Handler
import android.os.Looper
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.data.source.remote.response.MovieResponse
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.data.source.remote.response.TvShowResponse
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.utils.JsonHelper
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.utils.LoadMovieCallback
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.utils.LoadTvShowCallback
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.utils.MovieCallback

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {

    private val handler = Handler(Looper.getMainLooper())

    companion object{

        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000

        @Volatile
        private var instance: RemoteDataSource? = null
        fun getInstance(helper: JsonHelper): RemoteDataSource = instance ?: synchronized(this) {
            instance ?: RemoteDataSource(helper).apply {
                instance = this
            }
        }
    }

    fun getAllMovies(callback: LoadMovieCallback){
        handler.postDelayed({
            callback.onAllMoviesReceived(jsonHelper.loadMovies())
        }, SERVICE_LATENCY_IN_MILLIS )
    }

    fun getAllTvShow(callback: LoadTvShowCallback){
        handler.postDelayed({
            callback.onAllTvShowsReceived(jsonHelper.loadTvShows())
        }, SERVICE_LATENCY_IN_MILLIS )
    }

    fun getAllMoviesOld(): List<MovieResponse> = jsonHelper.loadMovies()

    fun getAllTvShowOld(): List<TvShowResponse> = jsonHelper.loadTvShows()
}
