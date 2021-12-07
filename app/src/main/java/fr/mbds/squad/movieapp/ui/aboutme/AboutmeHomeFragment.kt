package fr.mbds.squad.movieapp.ui.aboutme

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import fr.mbds.squad.movieapp.R
import fr.mbds.squad.movieapp.databinding.FragmentAboutmeHomeBinding
import fr.mbds.squad.movieapp.databinding.FragmentHomeBinding

class AboutmeHomeFragment : Fragment() {

    private lateinit var binding: FragmentAboutmeHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAboutmeHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
