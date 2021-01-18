package com.bobo.sunnyweather.logic.network


import com.bobo.sunnyweather.SunnyWeatherApplication
import com.bobo.sunnyweather.logic.model.Place
import com.bobo.sunnyweather.logic.model.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaceServcie {
    @GET("v2/place?token=${SunnyWeatherApplication.TOKEN}&lang=zh_CN")
    fun searchPlaces(@Query("query") query: String) : Call<PlaceResponse>
}