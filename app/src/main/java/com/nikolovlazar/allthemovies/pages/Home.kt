package com.nikolovlazar.allthemovies.pages

import android.widget.Spinner
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.nikolovlazar.allthemovies.Movie
import com.nikolovlazar.allthemovies.components.MovieRow

@Composable
fun Home(navController: NavController, movies: List<Movie>) {
  Scaffold(
    topBar = {
      TopAppBar(title = { Text("Home") })
    }
  ) { innerPadding ->
    Column(modifier = Modifier
      .padding(innerPadding)
      .padding(horizontal = 16.dp)
      .fillMaxWidth()
      .verticalScroll(
        rememberScrollState(),
        true
      )) {
      if (movies.isEmpty()) {
        CircularProgressIndicator()
      } else {
        movies.subList(0, 100).forEach { movie ->
          MovieRow(movie = movie, modifier = Modifier
            .padding(bottom = 16.dp, top = 8.dp)
            .clickable { navController.navigate("movies/${movie.id}") })
        }
      }
    }
  }
}