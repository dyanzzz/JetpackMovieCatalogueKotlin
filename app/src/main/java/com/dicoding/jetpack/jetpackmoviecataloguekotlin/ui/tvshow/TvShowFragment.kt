package com.dicoding.jetpack.jetpackmoviecataloguekotlin.ui.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ShareCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.R
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.adapter.MovieAdapter
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.data.MovieEntity
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.databinding.FragmentMovieBinding
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.utils.DataDummy
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.utils.MovieCallback
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.viewmodel.TvShowViewModel

class TvShowFragment : Fragment(), MovieCallback {

    private lateinit var fragmentMovieBinding: FragmentMovieBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragmentMovieBinding = FragmentMovieBinding.inflate(inflater, container, false)
        return fragmentMovieBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(activity != null){
            val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[TvShowViewModel::class.java]
            val tv = viewModel.getTvShow()

            val tvShowAdapter = MovieAdapter(this)
            tvShowAdapter.setMovies(tv)

            with(fragmentMovieBinding.rvMovie){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvShowAdapter
            }
        }
    }

    override fun onFavoriteClick(movie: MovieEntity){
        if(activity != null){
            Toast.makeText(context, "I Like this tv show "+movie.title, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onShareClick(movie: MovieEntity){
        if(activity != null){
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                    .from(requireActivity())
                    .setType(mimeType)
                    .setChooserTitle("Aplikasi onShare in")
                    .setText(resources.getString(R.string.share_content_tv, movie.title))
                    .startChooser()
        }
    }
}