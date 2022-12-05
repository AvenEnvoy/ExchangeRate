package com.bignerdranch.android.exchangerate.screens.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.bignerdranch.android.exchangerate.data.Repository
import com.bignerdranch.android.exchangerate.model.InputData
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(application: Application): AndroidViewModel(Application()) {
    var context = application
    private var repo = Repository()
    val inputData: MutableLiveData<InputData> = MutableLiveData()

    fun getDataList() {
        viewModelScope.launch {
            inputData.value = repo.getData()
        }
    }
}