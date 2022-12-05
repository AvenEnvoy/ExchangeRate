package com.bignerdranch.android.exchangerate.screens.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.bignerdranch.android.exchangerate.data.Repository
import com.bignerdranch.android.exchangerate.model.ValCurs
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(application: Application): AndroidViewModel(Application()) {
    var context = application
    var repo = Repository()
    val valuteList: MutableLiveData<Response<ValCurs>> = MutableLiveData()

    fun getDataList() {
        viewModelScope.launch {
            valuteList.value = repo.getData()
        }
    }
}