package com.sihabudin.recomovie.favorite

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.sihabudin.recomovie.core.ui.MovieAdapter
import com.sihabudin.recomovie.detail.DetailActivity
import com.sihabudin.recomovie.favorite.databinding.ActivityFavoriteBinding
import com.sihabudin.recomovie.favorite.di.favoriteModule
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules


class FavoriteActivity : AppCompatActivity() {
    private val favoriteViewModel: FavoriteViewModel by viewModel()
    private lateinit var binding: ActivityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)

        setContentView(binding.root)

        loadKoinModules(favoriteModule)

        val movieAdapter = MovieAdapter()
        movieAdapter.onItemClick = { selectedData ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_DATA, selectedData)
            startActivity(intent)
        }

        favoriteViewModel.movie.observe(this, { movies ->
            if (movies != null) {
                movieAdapter.setData(movies)
                binding.viewEmptyFavorite.root.visibility =
                    if (movies.isNotEmpty()) View.GONE else View.VISIBLE

            }
        })

        with(binding.rvMoviesFavorit) {
            layoutManager = GridLayoutManager(context, 2)
            setHasFixedSize(true)
            adapter = movieAdapter
        }
    }

}