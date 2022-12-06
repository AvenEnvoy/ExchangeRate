package com.bignerdranch.android.exchangerate.screens.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.bignerdranch.android.exchangerate.data.Repository
import com.bignerdranch.android.exchangerate.model.InputData
import kotlinx.coroutines.launch

class MainViewModel(application: Application): AndroidViewModel(Application()) {
    var context = application
    private var repo = Repository()
    lateinit var inputData: InputData

    fun getDataList() {
        viewModelScope.launch {
            inputData = repo.getData()
        }
    }
}