package com.sihabudin.recomovie.detail

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.bumptech.glide.Glide
import com.sihabudin.recomovie.R
import com.sihabudin.recomovie.core.domain.model.Movie
import com.sihabudin.recomovie.databinding.ActivityDetailBinding
import org.koin.android.viewmodel.ext.android.viewModel


class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private val detailViewModel: DetailViewModel by viewModel()
    private var movies: Movie? = null
    private var statusFavorit: Boolean? = false
    private val tagError: String = "TagDetailMovieError"
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        movies = intent.getParcelableExtra(EXTRA_DATA)
        setupDisplay(movies)

        checkFavorite(movies?.id)

        binding.ibIconfavoritDetail.setOnClickListener {
            movies?.let {
                try {
                    if (statusFavorit == false) {
                        detailViewModel.insertFavoriteMovie(it)
                    } else {
                        detailViewModel.deleteFavoriteMovie(it)
                    }

                    checkFavorite(movies?.id)
                } catch (ex: Exception) {
                    Log.e(tagError, ex.message!!)
                }

            }
        }

        binding.fab.setOnClickListener {
            finish()
        }

    }

    private fun setupDisplay(movies: Movie?) {
        val vReleaseDate = "Release Date : " + movies?.releaseDate
        Glide.with(this)
            .load(movies?.posterPath)
            .into(binding.ivPoster)

        Glide.with(this)
            .load(movies?.backdropPath)
            .into(binding.ivBackdropDetail)
        binding.tvOverviewDetail.text = movies?.overview
        binding.tvReleasedateDetail.text = vReleaseDate
        binding.tvTitleDetail.text = movies?.title
        binding.tvVoteDetail.text = movies?.voteAverage.toString()
        supportActionBar?.title = movies?.title
    }

    private fun checkFavorite(id: Int?) {

        if (id != null) {
            detailViewModel.getSingleFavoritMovie(id).observe(this, { movies ->

                if (movies.isNotEmpty()) {

                    statusFavorit = true
                    binding.ibIconfavoritDetail.setImageDrawable(
                        ResourcesCompat.getDrawable(
                            resources, R.drawable.ic_baseline_favorite_24, null
                        )
                    )
                } else {
                    statusFavorit = false
                    binding.ibIconfavoritDetail.setImageDrawable(
                        ResourcesCompat.getDrawable(
                            resources, R.drawable.ic_baseline_favorite_border_24, null
                        )
                    )

                }
            })
        } else {
            statusFavorit = false
            binding.ibIconfavoritDetail.setImageDrawable(
                ResourcesCompat.getDrawable(
                    resources, R.drawable.ic_baseline_favorite_border_24, null
                )
            )

        }
    }
}