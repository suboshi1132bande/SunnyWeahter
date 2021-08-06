package com.bobo.sunnyweather.logic.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Retrofit 构建起器
 */
object ServiceCreator {

    const val BEAS_URL = "https://api.caiyunapp.com/"

    private fun loggingIntercepter() : HttpLoggingInterceptor{
        var httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return httpLoggingInterceptor
    }

    val okhttpclien =OkHttpClient.Builder()
        .addInterceptor(loggingIntercepter())
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl(BEAS_URL)
        .client(okhttpclien)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    //泛型 实化
    inline fun<reified T> create() : T = create(T::class.java)
    fun<T> create(serviceClass: Class<T>) : T = retrofit.create(serviceClass)
}