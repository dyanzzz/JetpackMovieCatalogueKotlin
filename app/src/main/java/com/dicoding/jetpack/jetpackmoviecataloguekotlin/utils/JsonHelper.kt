package com.dicoding.jetpack.jetpackmoviecataloguekotlin.utils

import android.content.Context
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.data.source.remote.response.MovieResponse
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.data.source.remote.response.TvShowResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {

    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (ex: IOException){
            ex.printStackTrace()
            null
        }
    }

    fun loadMovies(): List<MovieResponse>{
        val list = ArrayList<MovieResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("movie.json").toString())
            val listArray = responseObject.getJSONArray("results")
            for (i in 0 until listArray.length()){
                val movie = listArray.getJSONObject(i)

                val id = movie.getInt("id")
                val title = movie.getString("title")
                val description = movie.getString("overview")
                val date = movie.getString("release_date")
                val posterPath = movie.getString("poster_path")
                val backdropPath = movie.getString("backdrop_path")
                val originalLanguage = movie.getString("original_language")
                val popularity = movie.getDouble("popularity")
                val voteAverage = movie.getDouble("vote_average")
                val voteCount = movie.getInt("vote_count")

                val movieResponse = MovieResponse(
                    id, title, description, date, posterPath, backdropPath, originalLanguage, popularity, voteAverage, voteCount
                )
                list.add(movieResponse)
            }
        }catch (ex: JSONException){
            ex.printStackTrace()
        }

        return list
    }

    fun loadTvShows(): List<TvShowResponse>{
        val list = ArrayList<TvShowResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("tvshow.json").toString())
            val listArray = responseObject.getJSONArray("results")
            for (i in 0 until listArray.length()){
                val movie = listArray.getJSONObject(i)

                val id = movie.getInt("id")
                val title = movie.getString("name")
                val description = movie.getString("overview")
                val date = movie.getString("first_air_date")
                val posterPath = movie.getString("poster_path")
                val backdropPath = movie.getString("backdrop_path")
                val originalLanguage = movie.getString("original_language")
                val popularity = movie.getDouble("popularity")
                val voteAverage = movie.getDouble("vote_average")
                val voteCount = movie.getInt("vote_count")

                val tvShowResponse = TvShowResponse(
                    id, title, description, date, posterPath, backdropPath, originalLanguage, popularity, voteAverage, voteCount
                )
                list.add(tvShowResponse)
            }
        }catch (ex: JSONException){
            ex.printStackTrace()
        }

        return list
    }
}