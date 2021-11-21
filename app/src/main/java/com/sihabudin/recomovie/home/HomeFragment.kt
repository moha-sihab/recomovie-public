package com.sihabudin.recomovie.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sihabudin.recomovie.R
import com.sihabudin.recomovie.core.data.Resource
import com.sihabudin.recomovie.core.ui.MovieHomeAdapter
import com.sihabudin.recomovie.databinding.FragmentHomeBinding
import com.sihabudin.recomovie.detail.DetailActivity
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModel()
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            setupDisplayPopular()
            setupDisplayTopRated()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupDisplayPopular() {
        val moviePopularAdapter = MovieHomeAdapter()

        moviePopularAdapter.onItemClick = { selectedData ->
            val intent = Intent(activity, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_DATA, selectedData)
            startActivity(intent)
        }
        homeViewModel.movie.observe(viewLifecycleOwner, { movies ->
            if (movies != null) {
                when (movies) {
                    is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                    is Resource.Success -> {
                        binding.progressBar.visibility = View.GONE
                        moviePopularAdapter.setData(movies.data)
                    }
                    is Resource.Error -> {
                        binding.progressBar.visibility = View.GONE
                        binding.viewError.tvError.visibility = View.VISIBLE
                        binding.viewError.tvError.text =
                            movies.message ?: getString(R.string.something_wrong)
                    }
                }
            }
        })

        val carRvMovies = binding.rvMovies
        carRvMovies.adapter = moviePopularAdapter
        carRvMovies.set3DItem(true)
        carRvMovies.setInfinite(true)
    }

    private fun setupDisplayTopRated() {
        val movieTopRatedAdapter = MovieHomeAdapter()

        movieTopRatedAdapter.onItemClick = { selectedData ->
            val intent = Intent(activity, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_DATA, selectedData)
            startActivity(intent)

        }

        homeViewModel.topRatedMovie.observe(viewLifecycleOwner, { moviestoprated ->
            if (moviestoprated != null) {
                when (moviestoprated) {
                    is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                    is Resource.Success -> {
                        binding.progressBar.visibility = View.GONE
                        movieTopRatedAdapter.setData(moviestoprated.data)
                    }
                    is Resource.Error -> {
                        binding.progressBar.visibility = View.GONE
                        binding.viewError.tvError.visibility = View.VISIBLE
                        binding.viewError.tvError.text =
                            moviestoprated.message ?: getString(R.string.something_wrong)
                    }
                }
            }
        })

        val carRvTopRatedMovies = binding.rvTopratedMovies
        carRvTopRatedMovies.adapter = movieTopRatedAdapter
        carRvTopRatedMovies.set3DItem(true)
        carRvTopRatedMovies.setInfinite(true)
    }
}