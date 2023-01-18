package com.nikolovlazar.allthemovies

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nikolovlazar.allthemovies.pages.Details
import com.nikolovlazar.allthemovies.pages.Home
import com.nikolovlazar.allthemovies.ui.theme.AllTheMoviesTheme
import java.io.IOException

class MainActivity : ComponentActivity() {
  @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      AllTheMoviesTheme {
        val navController = rememberNavController()
        Scaffold(
          content =  {
            NavHost(navController = navController, startDestination = "movies") {
              composable("movies") {
                Home(navController)
              }
              composable("movies/{id}") { backStackEntry ->
                Details(navController, bundle = backStackEntry.arguments)
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