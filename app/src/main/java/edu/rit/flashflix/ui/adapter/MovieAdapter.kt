package edu.rit.flashflix.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.rit.flashflix.R
import edu.rit.flashflix.data.model.Movie
import edu.rit.flashflix.databinding.MovieItemBinding
import edu.rit.flashflix.utils.loadUrl


class MovieAdapter(
    private val onTap: (Movie) -> Unit,
): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val binding = MovieItemBinding.bind(itemView)

        fun bind(movie: Movie) {
            binding.ivMovie.loadUrl("https://image.tmdb.org/t/p/original" + movie.poster_path, false)
        }
    }

    private var data: List<Movie> = listOf()

    fun setData(newData: List<Movie>) {
        data = newData
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.movie_item, parent, false)
        return MovieViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = data[position]
        holder.bind(movie)
        holder.itemView.setOnClickListener {
            onTap(movie)
        }
    }
}
















