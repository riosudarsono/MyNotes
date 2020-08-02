package com.rio.mynotes.data

import com.rio.mynotes.data.response.BaseResponse
import com.rio.mynotes.data.response.DataModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("search/movie")
    fun searchMovie(
        @Query("api_key") key: String,
        @Query("language") language: String,
        @Query("query") query: String
    ): Observable<BaseResponse<List<DataModel>>>
}