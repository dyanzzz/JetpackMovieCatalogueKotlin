package com.dicoding.jetpack.jetpackmoviecataloguekotlin.viewmodel

import androidx.lifecycle.ViewModel
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.data.MovieEntity
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.data.source.MovieRepository
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.utils.DataDummy

class DetailViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    private lateinit var movieId: String

    fun setSelectedMovie(movieId: String){
        this.movieId = movieId
    }

    fun getMovie2(): MovieEntity{
        lateinit var movie: MovieEntity
        val movieEntities = DataDummy.generateDummyMovie("movie")

        for(movieEntity in movieEntities){
            if(movieEntity.movieId == movieId){
                movie = movieEntity
            }else{
                val tvEntities = DataDummy.generateDummyMovie("tv")
                for(tvEntity in tvEntities) {
                    if (tvEntity.movieId == movieId) {
                        movie = tvEntity
                    }
                }
            }
        }

        return movie
    }

    fun getMovie(): MovieEntity = movieRepository.getMovieWithId(movieId)

    fun getTv(): MovieEntity = movieRepository.getTvShowWithId(movieId)
}
