package com.example.restapiclientproject

import com.example.restapiclientproject.modeldata.SearchData
import retrofit2.Call
import retrofit2.http.GET

interface ClientAPI {
    @GET("?s=avenger&apikey=5b513a97")
    fun getMovies(): Call<SearchData>
}