package com.bignerdranch.android.exchangerate.data

import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://cbr.ru/")
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build()
    }
    val api: ApiServices by lazy {
        retrofit.create(ApiServices::class.java)
    }
}