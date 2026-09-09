package com.example.icetask

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("api/topics")
    fun getTopics(): Call<List<Topic>>
}