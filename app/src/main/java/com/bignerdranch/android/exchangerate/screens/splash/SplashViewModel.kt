package com.bignerdranch.android.exchangerate.screens.splash

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.bignerdranch.android.exchangerate.model.InputData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import org.jsoup.select.Elements

class SplashViewModel(application: Application): AndroidViewModel(Application())  {
    val context = application
    var data: MutableLiveData<InputData> = MutableLiveData<InputData>()
    lateinit var table: Elements
    lateinit var value: Element
    private lateinit var doc: org.jsoup.nodes.Document

    fun getData() {
        try {
            viewModelScope.launch(Dispatchers.IO) {
                doc = Jsoup.connect("https://www.cbr.ru/scripts/XML_daily.asp?").get()
                table = doc.getElementsByTag("ValCurs")
                value = table[0]
                for (i in 0 until value.children().size) {
                    data.postValue(InputData(
                        value.children()[i].child(1).toString(),
                        value.children()[i].child(3).toString(),
                        value.children()[i].child(4).toString()))
                    println("${value.children()[i].child(1)}")
                }
            }
        } catch (ex: java.lang.Exception) {
            ex.printStackTrace()
        }
    }
}