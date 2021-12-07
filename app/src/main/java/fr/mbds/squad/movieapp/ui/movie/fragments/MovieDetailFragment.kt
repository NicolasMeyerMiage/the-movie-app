package fr.mbds.squad.movieapp.ui.movie.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.squareup.picasso.Picasso
import fr.mbds.squad.movieapp.R
import fr.mbds.squad.movieapp.databinding.FragmentMovieDetailBinding
import fr.mbds.squad.movieapp.ui.movie.MovieViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieDetailFragment : Fragment() {
    private val movieViewModel: MovieViewModel by viewModel()
    private val args: MovieDetailFragmentArgs by navArgs()
    private lateinit var binding: FragmentMovieDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieDetailBinding.inflate(inflater, container, false)
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
                    getMovieById(
                        args.movieId,
                        getString(
                            R.string.rest_langage
                        )
                    )
                }
            )
            movie.observe(
                viewLifecycleOwner,
                Observer {
                    binding.movieDetailName.text = movie.value?.name
                    binding.movieDetailOverview.text = movie.value?.overview
                    Picasso.get()
                        .load(movie.value?.poster)
                        .into(binding.movieDetailPoster)
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
