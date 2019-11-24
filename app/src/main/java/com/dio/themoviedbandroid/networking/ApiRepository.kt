package com.dio.themoviedbandroid.networking

import java.net.URL

class ApiRepository {
    fun doRequest(url: String): String{
        return URL (url).readText()
    }
}