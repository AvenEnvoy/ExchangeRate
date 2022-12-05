package com.bignerdranch.android.exchangerate.data

import com.bignerdranch.android.exchangerate.model.InputData

class Repository {
    suspend fun getData(): InputData {
        return RetrofitInstance.api.getData()
    }
}