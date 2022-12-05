package com.bignerdranch.android.exchangerate.data

import com.bignerdranch.android.exchangerate.model.InputData
import retrofit2.Response
import retrofit2.http.GET

interface ApiServices {

    @GET("https://cbr.ru/scripts/XML_daily.asp")
    suspend fun getData(): InputData
}