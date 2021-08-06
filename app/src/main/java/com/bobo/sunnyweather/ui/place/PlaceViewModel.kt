package com.bobo.sunnyweather.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.bobo.sunnyweather.logic.Repository
import com.bobo.sunnyweather.logic.model.Place
import java.util.ArrayList

class PlaceViewModel : ViewModel(){

    private val searchLiveData = MutableLiveData<String>()

    val placeList = ArrayList<Place>()

    val placeLiveData = Transformations.switchMap(searchLiveData){query ->
        Repository.searchPlaces(query)
    }

    fun searchPlace(query: String){
        searchLiveData.value = query
    }

    //fun savaPlace(place: Place) = Repository
}