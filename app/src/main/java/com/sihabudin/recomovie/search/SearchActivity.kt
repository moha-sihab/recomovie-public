package com.sihabudin.recomovie.search

import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.sihabudin.recomovie.R
import com.sihabudin.recomovie.core.data.Resource
import com.sihabudin.recomovie.core.ui.MovieAdapter
import com.sihabudin.recomovie.databinding.ActivitySearchBinding
import com.sihabudin.recomovie.detail.DetailActivity
import org.koin.android.viewmodel.ext.android.viewModel

@Suppress("NAME_SHADOWING")
class SearchActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySearchBinding
    private val searchViewModel: SearchViewModel by viewModel()
    private val movieAdapter = MovieAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        handleIntent(intent)

    }

    private fun handleIntent(intent: Intent) {

        if (Intent.ACTION_SEARCH == intent.action) {
            val query = intent.getStringExtra(SearchManager.QUERY)

            if (query != null) {
                movieAdapter.onItemClick = { selectedData ->
                    val intent = Intent(this, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_DATA, selectedData)
                    startActivity(intent)
                }

                title = " '" + query + "'"
                searchViewModel.searchMovie(query)
                    .observe(this@SearchActivity, { movies ->
                        if (movies != null) {
                            when (movies) {
                                is Resource.Loading -> binding.progressBarSearch.visibility =
                                    View.VISIBLE
                                is Resource.Success -> {
                                    binding.progressBarSearch.visibility = View.GONE
                                    binding.tvEmpty.visibility = View.GONE
                                    movieAdapter.setData(movies.data)
                                }
                                is Resource.Error -> {
                                    binding.progressBarSearch.visibility = View.GONE
                                    binding.tvEmpty.visibility = View.VISIBLE

                                }
                            }
                        }

                    })
                with(binding.rvMoviesSearch) {
                    layoutManager = GridLayoutManager(context, 2)
                    setHasFixedSize(true)
                    adapter = movieAdapter

                }
            }

        }
    }

}