package com.dio.themoviedbandroid.main

import com.dio.themoviedbandroid.model.MovieResponse
import com.dio.themoviedbandroid.networking.ApiRepository
import com.dio.themoviedbandroid.networking.TMDBApi
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainPresenter (private val view: MainView, private val apiRepository: ApiRepository, private val gson: Gson){
    fun getMovieList(){
        doAsync {
            val data = gson.fromJson(apiRepository.doRequest(TMDBApi.getMovie()),
                MovieResponse::class.java)
            uiThread {
                view.showMovieList(data.result)
            }
        }
    }
}