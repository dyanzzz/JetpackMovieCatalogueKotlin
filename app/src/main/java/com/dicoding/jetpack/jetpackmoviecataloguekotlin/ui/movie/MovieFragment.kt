package com.dicoding.jetpack.jetpackmoviecataloguekotlin.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ShareCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.R
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.adapter.MovieAdapter
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.data.MovieEntity
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.databinding.FragmentMovieBinding
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.utils.DataDummy
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.utils.MovieCallback

class MovieFragment : Fragment(), MovieCallback {

    private lateinit var fragmentMovieBinding: FragmentMovieBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragmentMovieBinding = FragmentMovieBinding.inflate(inflater, container, false)
        return fragmentMovieBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(activity != null){
            val movies = DataDummy.generateDummyMovie("movie")
            val movieAdapter = MovieAdapter(this)
            movieAdapter.setMovies(movies)

            with(fragmentMovieBinding.rvMovie){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }
    }

    override fun onFavoriteClick(movie: MovieEntity){
        if(activity != null){
            Toast.makeText(context, "I Like this movie "+movie.title, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onShareClick(movie: MovieEntity){
        if(activity != null){
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                    .from(requireActivity())
                    .setType(mimeType)
                    .setChooserTitle("Aplikasi onShare in")
                    .setText(resources.getString(R.string.share_content, movie.title))
                    .startChooser()
        }
    }
}