package com.example.food_app

import com.google.gson.Gson
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiService {

    @GET("/eaterapp/dishes")
    suspend fun GetDishes(@Header("Authorization") token: String): FoodList
}