package com.developersbreach.networkrequestexercise

import org.json.JSONObject
import java.net.URL

const val POSTER_APPEND_URL = "https://image.tmdb.org/t/p/w500"
const val MOVIE_URL = "https://api.themoviedb.org/3/movie/popular?api_key="

fun getMovieData(): List<Movie> {
    val requestUrl = URL(MOVIE_URL)
    val response: String = getResponseFromHttpsUrl(requestUrl)
    return fetchJsonMovieData(response)
}

fun fetchJsonMovieData(
    jsonResponse: String
): List<Movie> {

    // Empty list of movie objects
    val movieList = ArrayList<Movie>()

    val baseJsonObject = JSONObject(jsonResponse)
    val resultsArray = baseJsonObject.getJSONArray("results")

    for (i in 0 until resultsArray.length()) {

        val movieJsonObjects = resultsArray.getJSONObject(i)

        val movieTitle = movieJsonObjects.getString("title")
        val posterPath = movieJsonObjects.getString("poster_path")
        val poster = POSTER_APPEND_URL + posterPath

        val movie = Movie(movieTitle, poster)
        movieList.add(movie)
    }

    return movieList
}
