package com.dicoding.jetpack.jetpackmoviecataloguekotlin.adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.BuildConfig
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.R
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.data.MovieEntity
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.databinding.ItemMovieBinding
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.ui.detail.DetailActivity
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.utils.MovieCallback

class MovieAdapter(private val callback: MovieCallback): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    private var listMovies = ArrayList<MovieEntity>()

    fun setMovies(movies: List<MovieEntity>?){
        if(movies == null) return

        this.listMovies.clear()
        this.listMovies.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemMovieBinding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(itemMovieBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = listMovies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int {
        return listMovies.size
    }

    inner class MovieViewHolder(private val binding: ItemMovieBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(movie: MovieEntity){
            with(binding){
                tvItemTitle.text = movie.title
                tvItemDate.text = movie.date
                tvItemDescription.text = movie.description

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_MOVIE, movie)
                    itemView.context.startActivity(intent)
                }

                imgFavorite.setOnClickListener{
                    callback.onFavoriteClick(movie)
                }

                imgShare.setOnClickListener {
                    callback.onShareClick(movie)
                }

                Glide.with(itemView.context)
                        .load(BuildConfig.BASE_URL_IMG +"/"+ movie.imagePath)
                        .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                        .into(imgPoster)
            }
        }
    }
}