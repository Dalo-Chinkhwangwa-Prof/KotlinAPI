package com.dynamicdevz.ddkotlinmvp.model.network

import com.dynamicdevz.ddkotlinmvp.model.JikanResponse
import com.dynamicdevz.ddkotlinmvp.util.Constants.Companion.BASE_URL
import com.dynamicdevz.ddkotlinmvp.util.Constants.Companion.END_POINT
import com.dynamicdevz.ddkotlinmvp.util.Constants.Companion.SEARCH_QUERY
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

object JikanRetrofit {

    private val jikanService = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(JikanService::class.java)
    //   .build().create(JikanService.class)

    fun getJikan(search: String):Call<JikanResponse> = jikanService.getResponse(search)

    interface JikanService{
        /*@GET(END_POINT)
        public Call<JikanResponse> searchJikan(@Query(SEARCH_QUERY) String query);*/
        @GET(END_POINT)
        fun getResponse(@Query(SEARCH_QUERY) searchName: String): Call<JikanResponse>

    }
}







