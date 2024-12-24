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
import com.example.alextimofeev_android_hw16.databinding.FragmentMainBinding
import com.example.alextimofeev_android_hw16.di.DaggerAppComponent
import kotlinx.coroutines.launch


class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by viewModels {
        DaggerAppComponent.create().mainViewModelFactory()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.firstJoke()
        binding.refresh.setOnClickListener {
            viewModel.reloadJoke()
        }
        observeJokes()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun observeJokes() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.jokeActivity.collect { jokeActivity ->
                    if (jokeActivity != null) {
                        showJoke(jokeActivity.iconUrl, jokeActivity.joke)
                    }
                }
            }
        }
    }

    private fun showJoke(iconUrl:String, joke: String) {
        binding.image.load(iconUrl)
        binding.joke.text = joke
    }
}