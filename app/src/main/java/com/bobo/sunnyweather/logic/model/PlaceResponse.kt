package com.bobo.sunnyweather.logic.model

import com.google.gson.annotations.SerializedName
import java.net.Inet4Address


/**
 * https://api.caiyunapp.com/v2/place?query=深圳&token=iXWBBX6nFGTElc6r&lang=zh_CN
 *
 * {
"status": "ok",
"query": "深圳",
"places": [
{
"id": "place.7471532960694370",
"location": {
"lat": 22.535383,
"lng": 114.05471
},
"place_id": "mb-place.7471532960694370",
"name": "中华人民共和国广东省深圳市",
"formatted_address": "深圳市"
},
{
"id": "poi.884763292675",
"location": {
"lat": 22.633977,
"lng": 113.8093605
},
"place_id": "mb-poi.884763292675",
"name": "中华人民共和国广东省深圳市Airport S Rd深圳宝安国际机场",
"formatted_address": "深圳宝安国际机场"
},
{
"id": "poi.523986094849",
"location": {
"lat": 22.537462,
"lng": 113.9327345
},
"place_id": "mb-poi.523986094849",
"name": "中华人民共和国广东省深圳市南山大道2068号深圳大学",
"formatted_address": "深圳大学"
},
{
"id": "poi.300647806861",
"location": {
"lat": 22.546433,
"lng": 114.057764
},
"place_id": "mb-poi.300647806861",
"name": "中华人民共和国广东省深圳市福中路市民中心A区深圳博物馆历史馆",
"formatted_address": "深圳博物馆历史馆"
},
{
"id": "poi.798863984103",
"location": {
"lat": 22.486236,
"lng": 113.9113415
},
"place_id": "mb-poi.798863984103",
"name": "中华人民共和国广东省深圳市南山区蛇口太子路海上世界",
"formatted_address": "海上世界"
}
]
}
 */
data class PlaceResponse(val status: String, val places: List<Place>)

data class Place(val name: String, val location: Location, @SerializedName("formatted_address") val address: String)

data class Location(val lng: String, val lat: String)