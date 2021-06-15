package com.developersbreach.networkrequestexercise

import android.util.Log
import java.net.URL
import java.util.*
import javax.net.ssl.HttpsURLConnection
import kotlin.Exception

fun getResponseFromHttpsUrl(
    requestUrl: URL?
): String {

    // Open connection to HttpsURLConnection
    val urlConnection: HttpsURLConnection = requestUrl?.openConnection() as HttpsURLConnection
    var response = ""

    // Create try catch finally block
    try {
        // Inside try block
        // Return input stream from connection
        // Create scanner and allow it to stream
        // Use delimiter pattern and complete the scan
        // Save the response and close the scanner

        val inputStream = urlConnection.inputStream
        val scanner = Scanner(inputStream)
        scanner.useDelimiter("\\A")
        if (scanner.hasNext()){
            response = scanner.next()
        }
        scanner.close()

    } catch (exception: Exception) {
        // Inside catch block
        // Catch exceptions if necessary and print stack or either log it.
        exception.printStackTrace()
    } finally {
        // Inside finally block
        // Disconnect if any url connections are open
        urlConnection.disconnect()
    }
    // Return the response
    // Log and observe the json response
    Log.e("NetworkUtils", response)
    return response
}