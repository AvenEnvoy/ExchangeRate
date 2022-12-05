package com.bignerdranch.android.exchangerate.data

import retrofit2.Retrofit
import retrofit2.converter.jaxb.JaxbConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://cbr.ru/")
            .addConverterFactory(JaxbConverterFactory.create())
            .build()
    }
    val api: ApiServices by lazy {
        retrofit.create(ApiServices::class.java)
    }
}