package com.example.alextimofeev_android_hw16.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import coil.load
import com.example.alextimofeev_android_hw16.App
import com.example.alextimofeev_android_hw16.R
import com.example.alextimofeev_android_hw16.databinding.FragmentMainBinding
import com.example.alextimofeev_android_hw16.domain.entity.ChuckNorrisJoke
import com.example.alextimofeev_android_hw16.presentation.state.State
import kotlinx.coroutines.launch
import javax.inject.Inject


class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    private val viewModel: MainViewModel by viewModels {
        mainViewModelFactory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater)
        App.daggerAppComponent.injectMainFragment(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.firstJoke()
        binding.refresh.setOnClickListener {
            viewModel.reloadJoke()
        }
        observeViewState()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun observeViewState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect { state ->
                    setStateValues(state)
                }
            }
        }
    }

    private fun setStateValues(state: State) {
        with(binding) {
            progress.visibility = if (state is State.Loading) View.VISIBLE else View.INVISIBLE
            refresh.isEnabled = state !is State.Loading
            joke.visibility = if (state !is State.Loading) View.VISIBLE else View.INVISIBLE
            image.visibility = if (state is State.Success) View.VISIBLE else View.INVISIBLE

            if (state is State.Success) {
                showJoke(state.chuckNorrisJoke)
            }

            if (state is State.RequestNotCompleted) {
                joke.text = getString(R.string.request_not_completed)
            }

            if (state is State.Error) {
                joke.text = state.error
            }
        }
    }

    private fun showJoke(chuckNorrisJoke: ChuckNorrisJoke) {
        with(binding) {
            joke.text = chuckNorrisJoke.joke.toString()
            image.load(chuckNorrisJoke.iconUrl)
        }
    }
}