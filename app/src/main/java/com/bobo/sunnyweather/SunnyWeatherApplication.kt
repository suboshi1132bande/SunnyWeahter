package com.bobo.sunnyweather

import android.app.Application
import android.content.Context

class SunnyWeatherApplication : Application(){

    companion object{
        const val TOKEN = "iXWBBX6nFGTElc6r"  //填写申请到的takon
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}