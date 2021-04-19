package com.dicoding.jetpack.jetpackmoviecataloguekotlin.data.source

import com.dicoding.jetpack.jetpackmoviecataloguekotlin.data.MovieEntity
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.data.source.remote.RemoteDataSource

class MovieRepository private constructor(private val remoteDataSource: RemoteDataSource) : MovieDataSource {

    companion object{
        @Volatile
        private var instance: MovieRepository? = null

        fun getInstance(remoteDataSource: RemoteDataSource): MovieDataSource =
            instance ?: synchronized(this){
                instance ?: MovieRepository(remoteDataSource).apply {
                    instance = this
                }
            }
    }

    override fun getAllMovies(): List<MovieEntity> {
        val movieResponses = remoteDataSource.getAllMovies()
        val movieList = ArrayList<MovieEntity>()
        for(response in movieResponses){
            val movie = MovieEntity(
                response.id.toString(),
                response.title,
                response.date,
                "movie",
                response.overview,
                response.poster_path
            )

            movieList.add(movie)
        }
        return movieList
    }

    override fun getAllTvShow(): List<MovieEntity> {
        val tvShowResponse = remoteDataSource.getAllTvShow()
        val tvShowList = ArrayList<MovieEntity>()
        for (response in tvShowResponse){
            val tvShow = MovieEntity(
                response.id.toString(),
                response.name,
                response.first_air_date,
                "tv",
                response.overview,
                response.poster_path
            )

            tvShowList.add(tvShow)
        }
        return tvShowList
    }

    fun getMovieWithId(movieId: String): MovieEntity {
        val movieResponse = remoteDataSource.getAllMovies()
        lateinit var movie: MovieEntity
        for (response in movieResponse){
            if(response.id.toString() == movieId) {
                movie = MovieEntity(
                    response.id.toString(),
                    response.title,
                    response.date,
                    "movie",
                    response.overview,
                    response.poster_path
                )
            }
        }
        return movie
    }

    fun getTvShowWithId(tvId: String): MovieEntity {
        val tvShowResponse = remoteDataSource.getAllTvShow()
        lateinit var tv: MovieEntity
        for (response in tvShowResponse){
            if(response.id.toString() == tvId) {
                tv = MovieEntity(
                    response.id.toString(),
                    response.name,
                    response.first_air_date,
                    "tv",
                    response.overview,
                    response.poster_path
                )
            }
        }
        return tv
    }

}