package com.mb.newsappletzte.data.remote

import com.mb.newsappletzte.data.remote.dto.NewsResponse
import com.mb.newsappletzte.domain.model.Source
import com.mb.newsappletzte.utils.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface GetNewsApi {

    @GET("everything")
    suspend fun getNews(
        @Query("sources") sources : String,
        @Query("page") page : Int,
        @Query("apiKey") apiKey : String = API_KEY
    ) : NewsResponse
}