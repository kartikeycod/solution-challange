package com.example.cropulse_kritrim

import android.telecom.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("weather")
    fun getWeatherData(
        @Query("q") city:String ,
        @Query("appid") appid:String ,
        @Query("units") units:String
    ) : retrofit2.Call<WeatherApp>
}