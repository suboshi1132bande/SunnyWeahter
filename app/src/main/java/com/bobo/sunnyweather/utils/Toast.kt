package com.bobo.sunnyweather.utils

import android.widget.Toast
import com.bobo.sunnyweather.SunnyWeatherApplication

fun String.showToast(time: Int = Toast.LENGTH_SHORT){
    Toast.makeText(SunnyWeatherApplication.context,this,time).show()
}

fun Int.showToast(time: Int = Toast.LENGTH_SHORT){
    Toast.makeText(SunnyWeatherApplication.context,this,time).show()
}