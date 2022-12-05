package com.bignerdranch.android.exchangerate.data

import com.bignerdranch.android.exchangerate.model.ValCurs
import retrofit2.Response

class Repository {
    suspend fun getData(): Response<ValCurs> {
        return RetrofitInstance.api.getData()
    }
}