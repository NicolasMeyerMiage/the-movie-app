package fr.mbds.squad.movieapp.ui.tv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import fr.mbds.squad.movieapp.R
import fr.mbds.squad.movieapp.databinding.FragmentTvBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class TvFragment : Fragment() {

    private val tvViewModel: TvViewModel by viewModel()
    private val args: TvFragmentArgs by navArgs()
    private lateinit var binding: FragmentTvBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTvBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).supportActionBar?.title =
            getString(R.string.title_tv) + " - " + args.catName

        with(tvViewModel) {
            token.observe(
                viewLifecycleOwner,
                Observer {
                    getTvsByCategoryId(args.catId)
                }
            )
            tvs.observe(
                viewLifecycleOwner,
                Observer {
                    binding.tvList.adapter = TvAdapter(it)
                }
            )
            error.observe(
                viewLifecycleOwner,
                Observer {
                }
            )
        }
    }
}
