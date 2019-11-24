package com.dio.themoviedbandroid.networking

import com.dio.themoviedbandroid.BuildConfig.API_KEY
import com.dio.themoviedbandroid.BuildConfig.BASE_URL

object TMDBApi {
    fun getMovie(): String{
        return BASE_URL + API_KEY
    }
}