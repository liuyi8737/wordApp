package com.example.wordapp.data

import android.content.Context
import android.util.Log
import com.example.wordapp.R

class DataSource(context: Context) {
    var letterLists = (('A')..('Z')).toList()
    var wordLists = context.resources.getStringArray(R.array.words)

    //获取letters
    fun loadLetters():List<Char> = letterLists

    //获取letter对应的单词
    fun queryWords(prefix:String):List<String>{

        val result = wordLists.filter {
            it.startsWith(prefix,true)
        }
        return result
    }
}