package com.bobo.sunnyweather.logic.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Retrofit 构建起器
 */
object ServiceCreator {
    const val BEAS_URL = "https://api.caiyunapp.com/"
    val retrofit = Retrofit.Builder()
        .baseUrl(BEAS_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    //泛型 实化
    inline fun<reified T> create() : T = create(T::class.java)
    fun<T> create(serviceClass: Class<T>) : T = retrofit.create(serviceClass)
}