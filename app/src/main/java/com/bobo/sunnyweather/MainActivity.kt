package com.bobo.sunnyweather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bobo.mylibrary.utils.LogUtil

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        LogUtil.v(TAG," pull test")
    }
}