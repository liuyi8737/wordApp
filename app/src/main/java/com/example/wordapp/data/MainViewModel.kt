package com.example.wordapp.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel

class MainViewModel(application: Application):AndroidViewModel(application) {

    private val dataSource = DataSource(getApplication<Application>().applicationContext)

    fun loadLetters():List<Char> = dataSource.loadLetters()
    fun queryWords(prefix:String):List<String> = dataSource.queryWords(prefix)
}