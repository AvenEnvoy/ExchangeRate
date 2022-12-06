package com.bignerdranch.android.exchangerate.data

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

object RetrofitInstance {
    private val httpClient: OkHttpClient = OkHttpClient.Builder().build()

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("http://www.cbr.ru/")
            .client(httpClient)
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build()
    }
    val api: ApiServices by lazy {
        retrofit.create(ApiServices::class.java)
    }
}