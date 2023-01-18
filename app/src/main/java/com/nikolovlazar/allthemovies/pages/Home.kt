package com.nikolovlazar.allthemovies.pages

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.nikolovlazar.allthemovies.Movie
import com.nikolovlazar.allthemovies.components.MovieRow
import com.nikolovlazar.allthemovies.movies

@Composable
fun Home(navController: NavController) {
  //    val jsonFileString = getJsonDataFromAsset(applicationContext, "movies.json")
  //    val gson = Gson()
  //    val movies: List<Movie> = gson.fromJson(jsonFileString, object : TypeToken<List<Movie>>() {}.type)

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
      movies.forEach { movie ->
        MovieRow(movie = movie, modifier = Modifier
          .padding(bottom = 16.dp, top = 8.dp)
          .clickable { navController.navigate("movies/${movie.id}") })
      }
    }
  }
}