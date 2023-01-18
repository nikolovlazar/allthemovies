package com.nikolovlazar.allthemovies

data class Movie(
  val id: Int,
  val title: String,
  val year: Int,
  val cast: List<String>,
  val genres: List<String>
) {}