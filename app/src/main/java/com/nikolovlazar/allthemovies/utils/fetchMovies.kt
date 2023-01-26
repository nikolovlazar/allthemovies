package com.nikolovlazar.allthemovies.utils

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nikolovlazar.allthemovies.Movie
import java.io.IOException

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

fun fetchMovies(context: Context): List<Movie> {
  val jsonFileString = getJsonDataFromAsset(context, "movies.json")
  val gson = Gson()
  val movies: List<Movie> = gson.fromJson(
    jsonFileString,
    object : TypeToken<List<Movie>>() {}.type
  )
  return movies
}