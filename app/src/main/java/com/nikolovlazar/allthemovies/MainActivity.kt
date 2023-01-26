package com.nikolovlazar.allthemovies

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.*
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nikolovlazar.allthemovies.pages.Details
import com.nikolovlazar.allthemovies.pages.Home
import com.nikolovlazar.allthemovies.ui.theme.AllTheMoviesTheme
import com.nikolovlazar.allthemovies.utils.fetchMovies
import java.io.IOException

class MainActivity : ComponentActivity() {
  private val viewModel by viewModels<MoviesViewModel>()

  @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val data = fetchMovies(applicationContext)
    viewModel.setMovies(data)

//    GlobalScope.launch(Dispatchers.IO) {
//      val data = fetchMovies(applicationContext)
//      viewModel.setMovies(data)
//    }

    setContent {
      AllTheMoviesTheme {
        val navController = rememberNavController()
        val movies: List<Movie> by viewModel.state.collectAsState()
        Scaffold(
          content =  {
            NavHost(navController = navController, startDestination = "movies") {
              composable("movies") {
                Home(navController, movies)
              }
              composable("movies/{id}") { backStackEntry ->
                Details(navController, movies, bundle = backStackEntry.arguments)
              }
            }
          }
        )
      }
    }
  }
}

fun getJsonDataFromAsset(context: Context, fileName: String): String? {
  val jsonString: String
  try {
    jsonString = context.assets.open(fileName).bufferedReader().use {
      it.readText()
    }
  } catch (ioException: IOException) {
    ioException.printStackTrace()
    return null
  }
  return jsonString
}