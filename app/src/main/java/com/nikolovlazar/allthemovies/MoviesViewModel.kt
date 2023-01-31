package com.nikolovlazar.allthemovies

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.nikolovlazar.allthemovies.utils.fetchMovies
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MoviesViewModel(application: Application) :
  AndroidViewModel(application) {

  private val _state = MutableStateFlow(listOf<Movie>())

  init {
    _state.value = fetchMovies(application)
      .sortedByDescending { movie -> movie.year }
      .subList(0, 300)

//    viewModelScope.launch(Dispatchers.IO) {
//      _state.value = fetchMovies(application)
//        .sortedByDescending { movie -> movie.year }
//        .subList(0, 300)
//    }
  }

  val state: StateFlow<List<Movie>>
    get() = _state.asStateFlow()
}