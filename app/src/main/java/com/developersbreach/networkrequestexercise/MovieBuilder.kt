package com.developersbreach.networkrequestexercise

import org.json.JSONObject
import java.net.URL

const val POSTER_APPEND_URL = "https://image.tmdb.org/t/p/w500"
const val MOVIE_URL =
    "https://api.themoviedb.org/3/movie/popular?api_key="


fun getMovieData(): List<Movie> {
    // First save the string url in variable
    val stringUrl = MOVIE_URL

    // Convert the string to url by passing string to URL object
    val requestUrl: URL = URL(stringUrl)

    // Pass the created url and send a request to https to receive json response
    val response = getResponseFromHttpsUrl(requestUrl)

    // After receiving the json response, send that json data to new function
    // a function which constructs the objects and arrays and gets all properties
    return fetchJsonMovieData(response)
}


fun fetchJsonMovieData(
    jsonResponse: String
): List<Movie> {

    // First create a empty ArrayList of type Movie objects.
    val movieListData = ArrayList<Movie>()

    // Create base jsonObject and pass the response
    val baseJsonObject = JSONObject(jsonResponse)

    // Look into nested objects or arrays and create more objects
    val resultsArray = baseJsonObject.getJSONArray("results")

    // If found array, loop inside all objects
    for (i in 0 until resultsArray.length()) {
        // Look for more nested objects before observing properties
        val movieJsonObjects = resultsArray.getJSONObject(i)

        // Get all the properties from object lastly created
        val title = movieJsonObjects.getString("title")
        val poster = POSTER_APPEND_URL + movieJsonObjects.getString("poster_path")

        // Return all those properties of type new movie object
        val movie = Movie(title, poster)

        // Add each object to empty ArrayList which we have created
        movieListData.add(movie)
    }

    // Finally return the movie list data.
    return movieListData
}