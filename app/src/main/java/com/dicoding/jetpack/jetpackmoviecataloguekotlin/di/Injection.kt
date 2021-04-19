package com.dicoding.jetpack.jetpackmoviecataloguekotlin.di

import android.content.Context
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.data.source.MovieDataSource
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.data.source.MovieRepository
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.data.source.remote.RemoteDataSource
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): MovieDataSource {
        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        return MovieRepository.getInstance(remoteDataSource)
    }
}