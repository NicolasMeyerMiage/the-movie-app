package fr.mbds.squad.movieapp.ui.movie.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import fr.mbds.squad.idbdata.data.Movie
import fr.mbds.squad.movieapp.databinding.MovieItemListBinding
import fr.mbds.squad.movieapp.ui.movie.fragments.MovieFragmentDirections

class MovieAdapter(
    private val items: List<Movie>
) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: MovieItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val posterMovie: ImageView = binding.moviePoster

        fun bind(item: Movie) {
            binding.item = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(MovieItemListBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])

        holder.itemView.setOnClickListener {
            val action =
                MovieFragmentDirections.actionMovieFragmentToMovieDetailFragment(
                    items[position].id.toString(),
                    items[position].name
                )
            Navigation.findNavController(it).navigate(action)
        }

        val movie: Movie = items[position]

        Picasso.get()
            .load(movie.poster)
            .into(holder.posterMovie)
    }
}
