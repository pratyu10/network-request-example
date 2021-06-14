package com.developersbreach.networkrequestexercise

const val POSTER_APPEND_URL = "https://image.tmdb.org/t/p/w500"
const val MOVIE_URL = "https://api.themoviedb.org/3/movie/popular?api_key=d77b5ab884174f60f4c9e8f50a70d99c"


fun getMovieData(): List<Movie> {

    // TODO

    // First save the string url in variable

    // Convert the string to url by passing string to URL object

    // Pass the created url and send a request to https to receive json response

    // After receiving the json response, send that json data to new function
    // a function which constructs the objects and arrays and gets all properties

    return listOf<Movie>()
}


fun fetchJsonMovieData(
    jsonResponse: String
): List<Movie> {

    // TODO

    // First create a empty ArrayList of type Movie objects.

    // Create base jsonObject and pass the response

    // Look into nested objects or arrays and create more objects

    // If found array, loop inside all objects

    // Look for more nested objects before observing properties

    // Get all the properties from object lastly created

    // Return all those properties of type new movie object
    // Add each object to empty ArrayList which we have created

    // Finally return the movie list data.

    return listOf<Movie>()
}
