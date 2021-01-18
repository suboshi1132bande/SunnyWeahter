package com.bobo.sunnyweather.logic.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.RuntimeException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

object SunnyWheaterNetwork {
    private val placeServcie = ServiceCreator.create<PlaceServcie>()

    //定义一个挂起函数
    suspend fun searchPlaces(qurery: String) = placeServcie.searchPlaces(qurery).await()

    private suspend fun<T> Call<T>.await() : T {
        return suspendCoroutine {
            enqueue(object : Callback<T>{
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    if (body !=null ){
                        it.resume(body)
                    }else{
                        it.resumeWithException(RuntimeException("respones body is null"))
                    }
                }

                override fun onFailure(call: Call<T>, t: Throwable) {
                    it.resumeWithException(t)
                }

            })
        }
    }
}