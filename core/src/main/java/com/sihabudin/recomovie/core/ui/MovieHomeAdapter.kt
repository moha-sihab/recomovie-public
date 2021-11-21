package com.sihabudin.recomovie.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sihabudin.recomovie.core.R
import com.sihabudin.recomovie.core.databinding.ItemMovieHomeBinding
import com.sihabudin.recomovie.core.databinding.ItemMovieListBinding
import com.sihabudin.recomovie.core.domain.model.Movie
import java.util.ArrayList

class MovieHomeAdapter : RecyclerView.Adapter<MovieHomeAdapter.ListViewHolder>() {

    private var listData = ArrayList<Movie>()
    var onItemClick: ((Movie) -> Unit)? = null

    fun setData(newListData: List<Movie>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_movie_home, parent, false)
        )

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemMovieHomeBinding.bind(itemView)
        fun bind(data: Movie) {
            Glide.with(itemView.context)
                .load(data.posterPath)
                .placeholder(R.drawable.spinner)
                .into(binding.ivHomeImage)
            binding.tvHomeVote.text = data.voteAverage.toString()
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }
}