package com.developersbreach.networkrequestexercise.view.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.developersbreach.networkrequestexercise.*
import com.developersbreach.networkrequestexercise.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val popularRecyclerView: RecyclerView = view.findViewById(R.id.movies_recycler_view)
        val progressPopularMovies: ProgressBar = view.findViewById(R.id.progress_popular_movies)

        progressPopularMovies.visibility = View.VISIBLE

        viewLifecycleOwner.lifecycleScope.launch {
            val movieList = getMoviesList()
            val adapter = MovieAdapter(movieList, listener)
            popularRecyclerView.adapter = adapter
            progressPopularMovies.visibility = View.INVISIBLE
        }
    }

    private suspend fun getMoviesList(): List<Movie> {
        var movieList: List<Movie>
        withContext(Dispatchers.Default) {
            movieList = getMovieData()
        }
        return movieList
    }

    private val listener = MovieAdapter.OnClickListener { movie ->
        findNavController().navigate(
            ListFragmentDirections.listToDetailFragment(movie)
        )
    }
}