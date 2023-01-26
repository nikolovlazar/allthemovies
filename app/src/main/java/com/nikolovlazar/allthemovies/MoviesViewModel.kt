package com.nikolovlazar.allthemovies

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MoviesViewModel : ViewModel() {
  private val _state = MutableStateFlow(listOf<Movie>())

  val state: StateFlow<List<Movie>>
    get() = _state.asStateFlow()

  fun setMovies(movies: List<Movie>) {
    _state.value = movies
  }
}