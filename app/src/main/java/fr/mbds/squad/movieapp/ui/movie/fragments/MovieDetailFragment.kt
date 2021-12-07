package fr.mbds.squad.movieapp.ui.movie.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import fr.mbds.squad.movieapp.R
import fr.mbds.squad.movieapp.databinding.FragmentMovieDetailBinding
import fr.mbds.squad.movieapp.ui.movie.MovieViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieDetailFragment : Fragment() {
    private val movieViewModel: MovieViewModel by viewModel()
    private val args: MovieDetailFragmentArgs by navArgs()
    private lateinit var binding: FragmentMovieDetailBinding
    private lateinit var movieName: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieDetailBinding.inflate(inflater, container, false)
        val view = inflater.inflate(R.layout.fragment_movie_detail, container, false)
        movieName = view.findViewById(R.id.movie_detail_name)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = getString(
            R.string.title_detail_movie
        ) + " - " + args.movieName
        with(movieViewModel) {
            token.observe(
                viewLifecycleOwner,
                Observer {
                    getMovieById(args.movieId)
                }
            )
            movie.observe(
                viewLifecycleOwner,
                Observer {
                    movieName.text = args.movieName
                }
            )
            error.observe(
                viewLifecycleOwner,
                Observer {
                    // afficher l'erreur
                }
            )
        }
    }
}
