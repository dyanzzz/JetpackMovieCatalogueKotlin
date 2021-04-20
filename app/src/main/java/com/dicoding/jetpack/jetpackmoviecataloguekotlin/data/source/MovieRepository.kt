package com.dicoding.jetpack.jetpackmoviecataloguekotlin.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.data.MovieEntity
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.data.source.remote.RemoteDataSource
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.data.source.remote.response.MovieResponse
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.data.source.remote.response.TvShowResponse
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.utils.LoadMovieCallback
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.utils.LoadTvShowCallback

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

    override fun getAllMovies(): LiveData<List<MovieEntity>> {
        //val movieResponses = remoteDataSource.getAllMovies()
        val movieResult = MutableLiveData<List<MovieEntity>>()

        remoteDataSource.getAllMovies(object : LoadMovieCallback {
            override fun onAllMoviesReceived(movieResponses: List<MovieResponse>) {
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
                movieResult.postValue(movieList)
            }
        })
        return movieResult
    }

    override fun getAllTvShow(): LiveData<List<MovieEntity>> {
        //val tvShowResponses = remoteDataSource.getAllTvShow()
        val tvShowResult = MutableLiveData<List<MovieEntity>>()

        remoteDataSource.getAllTvShow(object : LoadTvShowCallback {
            override fun onAllTvShowsReceived(tvShowResponses: List<TvShowResponse>) {
                val tvShowList = ArrayList<MovieEntity>()
                for (response in tvShowResponses){
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
                tvShowResult.postValue(tvShowList)
            }
        })

        return tvShowResult
    }

    fun getMovieWithId(movieId: String): LiveData<MovieEntity> {
        val movieResult = MutableLiveData<MovieEntity>()
        //val movieResponses = remoteDataSource.getAllMovies()

        remoteDataSource.getAllMovies(object : LoadMovieCallback {
            override fun onAllMoviesReceived(movieResponses: List<MovieResponse>) {
                lateinit var movie: MovieEntity
                for (response in movieResponses){
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
                movieResult.postValue(movie)
            }
        })

        return movieResult
    }

    fun getTvShowWithId(tvId: String): LiveData<MovieEntity> {
        val tvShowResult = MutableLiveData<MovieEntity>()
        //val tvShowResponses = remoteDataSource.getAllTvShow()

        remoteDataSource.getAllTvShow(object : LoadTvShowCallback {
            override fun onAllTvShowsReceived(tvShowResponses: List<TvShowResponse>) {
                lateinit var tv: MovieEntity
                for (response in tvShowResponses){
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
                tvShowResult.postValue(tv)
            }
        })

        return tvShowResult
    }

}