package com.nikolovlazar.allthemovies.pages

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
      .fillMaxSize()) {
      if (movies.isEmpty()) {
        CircularProgressIndicator()
      } else {
        LazyColumn {
          items(movies) { movie ->
            MovieRow(movie = movie, modifier = Modifier
              .padding(bottom = 16.dp, top = 8.dp)
              .clickable { navController.navigate("movies/${movie.id}") })
          }
        }
      }
    }
  }
}