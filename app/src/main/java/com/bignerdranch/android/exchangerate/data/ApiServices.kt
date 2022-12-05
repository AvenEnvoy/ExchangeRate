package com.bignerdranch.android.exchangerate.data

import com.bignerdranch.android.exchangerate.model.ValCurs
import retrofit2.Response
import retrofit2.http.GET

interface ApiServices {

    @GET("scripts/XML_daily.asp")
    suspend fun getData(): Response<ValCurs>
}