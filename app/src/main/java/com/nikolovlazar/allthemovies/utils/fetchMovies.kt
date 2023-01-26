package com.nikolovlazar.allthemovies.utils

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nikolovlazar.allthemovies.Movie
import com.nikolovlazar.allthemovies.getJsonDataFromAsset

fun fetchMovies(context: Context): List<Movie> {
  val jsonFileString = getJsonDataFromAsset(context, "movies.json")
  val gson = Gson()
  val movies: List<Movie> = gson.fromJson(
    jsonFileString,
    object : TypeToken<List<Movie>>() {}.type
  )
  return movies
}