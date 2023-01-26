package com.nikolovlazar.allthemovies.pages

import android.os.Bundle
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.nikolovlazar.allthemovies.Movie

@Composable
fun Details(navController: NavController, movies: List<Movie>, bundle: Bundle?) {
  val movieId = Integer.parseInt(bundle?.getString("id") ?: "-1")
  val movie = movies.find { movie -> movie.id == movieId }

  Scaffold(
    topBar = {
      TopAppBar(
        title = { Text(movie?.title ?: "No movie found!", maxLines = 1, overflow = TextOverflow.Ellipsis) },
        navigationIcon = {
          IconButton(onClick = { navController.popBackStack() }) {
            Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Go back")
          }
        }
      )
    }
  ) { innerPadding ->
    if (movieId == -1 || movie == null) {
      Text("No movie found with the id: $movieId")
    } else {
      Column(modifier = Modifier
        .padding(innerPadding)
        .padding(16.dp)) {
        Row {
          Text("Title:")
          Text(movie.title, modifier = Modifier.padding(start = 10.dp))
        }
        Row {
          Text("Year:")
          Text("${movie.year}", modifier = Modifier.padding(start = 10.dp))
        }
        Row {
          Text("Genres:")
          Text(movie.genres.joinToString(", "), modifier = Modifier.padding(start = 10.dp))
        }
        Row {
          Text("Cast:")
          Text(movie.cast.joinToString(", "), modifier = Modifier.padding(start = 10.dp))
        }
      }
    }
  }
}