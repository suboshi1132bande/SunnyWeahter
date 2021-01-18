package com.bobo.mylibrary.utils

import android.util.Log

object LogUtil {
    private const val V = 1
    private const val D = 2
    private const val I = 3
    private const val W = 4
    private const val E = 5

    private var level = V   //调试环境可以显示 v 级别 生产环境 只显示 E

    fun v(tag: String, msg: String){
        if (level <= V){
            Log.v(tag,msg)
        }
    }

    fun d(tag: String, msg: String){
        if (level <= D){
            Log.d(tag,msg)
        }
    }

    fun i(tag: String, msg: String){
        if (level <= I){
            Log.i(tag,msg)
        }
    }

    fun w(tag: String, msg: String){
        if (level <= W){
            Log.w(tag,msg)
        }
    }

    fun e(tag: String, msg: String){
        if (level <= E){
            Log.e(tag,msg)
        }
    }
}