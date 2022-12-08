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
    var data: MutableList<InputData> = mutableListOf()

    fun getData() {
        try {
            viewModelScope.launch(Dispatchers.IO) {
                val doc = Jsoup.connect("https://www.cbr.ru/scripts/XML_daily.asp?").get()
                val table = doc.getElementsByTag("ValCurs")
                val value = table[0]
                for (i in 0 until value.children().size) {
                    data.add(InputData(
                        value.children()[i].child(1).text(),
                        value.children()[i].child(2).text(),
                        value.children()[i].child(4).text()))
                }
            }
        } catch (ex: java.lang.Exception) {
            ex.printStackTrace()
        }
    }
}