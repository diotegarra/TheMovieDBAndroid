package com.dio.themoviedbandroid.main

import com.dio.themoviedbandroid.model.Movie

interface MainView {
    fun showMovieList(result: List<Movie>)
}