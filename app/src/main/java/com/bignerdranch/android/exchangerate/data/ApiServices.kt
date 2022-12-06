package com.bignerdranch.android.exchangerate.data

import com.bignerdranch.android.exchangerate.model.InputData
import retrofit2.http.GET

interface ApiServices {

    @GET("scripts/XML_daily.asp")
    suspend fun getData(): InputData
}