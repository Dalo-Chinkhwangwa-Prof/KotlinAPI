package com.dynamicdevz.ddkotlinmvp.util

import android.util.Log

class Constants {
    companion object{
        @JvmStatic
        val BASE_URL = "https://api.jikan.moe/"
        const val END_POINT = "v3/search/anime"
        const val SEARCH_QUERY = "q"
        fun sayHi(){
            Log.d("TAG_X", "")
        }
    }
}