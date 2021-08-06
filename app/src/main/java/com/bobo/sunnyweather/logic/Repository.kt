package com.bobo.sunnyweather.logic

import kotlinx.coroutines.Dispatchers
import androidx.lifecycle.liveData
import com.bobo.sunnyweather.logic.model.Place
import com.bobo.sunnyweather.logic.model.PlaceResponse
import com.bobo.sunnyweather.logic.network.PlaceServcie
import com.bobo.sunnyweather.logic.network.SunnyWheaterNetwork
import java.lang.RuntimeException

object Repository {

    fun searchPlaces(query: String) = liveData(Dispatchers.IO) {
        val result = try {
            val paceResponse = SunnyWheaterNetwork.searchPlaces(query)
            if (paceResponse.status  == "ok"){
                val place = paceResponse.places
                Result.success(place)
            }else{
                Result.failure(RuntimeException("response status is ${paceResponse.status}"))
            }
        }catch (e: Exception){
            Result.failure<List<Place>>(e)
        }
        emit(result)
    }
}