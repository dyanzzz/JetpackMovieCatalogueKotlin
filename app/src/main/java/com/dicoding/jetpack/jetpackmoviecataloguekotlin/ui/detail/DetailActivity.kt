package com.dicoding.jetpack.jetpackmoviecataloguekotlin.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.BuildConfig
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.R
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.data.MovieEntity
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.databinding.ActivityDetailBinding
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.viewmodel.DetailViewModel
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.viewmodel.ViewModelFactory

class DetailActivity : AppCompatActivity() {

    private lateinit var activityDetailBinding: ActivityDetailBinding

    companion object{
        const val EXTRA_MOVIE = "extra_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityDetailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(activityDetailBinding.root)

        setSupportActionBar(activityDetailBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        val extras = intent.extras
        if(extras != null){
            val movie = intent.getParcelableExtra<MovieEntity>(EXTRA_MOVIE) as MovieEntity
            //val movie = extras.getString(EXTRA_MOVIE)

            viewModel.setSelectedMovie(movie.movieId)
            if(movie.category == "movie") {
                populateMovie(viewModel.getMovie())
            }else{
                populateMovie(viewModel.getTv())
            }

            /*
                for (movie in DataDummy.generateDummyMovie("movie")){
                if(movie.movieId == movieId){
                    populateMovie(movie)
                }else{
                    for (tv in DataDummy.generateDummyMovie("tv")){
                        if(tv.movieId == movieId){
                            populateMovie(tv)
                        }
                    }
                }
            */

        }

    }

    private fun populateMovie(movie: MovieEntity){
        activityDetailBinding.textTitle.text = movie.title
        activityDetailBinding.textDate.text = movie.date
        activityDetailBinding.textDescription.text = movie.description
        val category = if (movie.category == "movie") "Movie Catalogue" else "Tv Show Catalogue"
        activityDetailBinding.textTag.text = category

        Glide.with(this)
            .load(BuildConfig.BASE_URL_IMG_HIGHT +"/"+ movie.imagePath)
                .transform(RoundedCorners(20))
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(activityDetailBinding.imagePoster)

    }
}