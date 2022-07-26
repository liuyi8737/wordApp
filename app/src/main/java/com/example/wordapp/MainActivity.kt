package com.example.wordapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.wordapp.data.MainViewModel

class MainActivity : AppCompatActivity() {
    var isLinearLayout = true
    lateinit var model: MainViewModel
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        model = ViewModelProvider(this).get(MainViewModel::class.java)
        recyclerView = findViewById(R.id.recyclerView)
        PagerSnapHelper().attachToRecyclerView(recyclerView)
        recyclerView.adapter = LettersAddapter().apply {
            setData(model.loadLetters())
        }
        changeLayout()
    }

    fun changeLayout(){
        if (isLinearLayout){
            recyclerView.layoutManager = LinearLayoutManager(this)
        }else{
            recyclerView.layoutManager = GridLayoutManager(this,2)
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //解析menu下面的菜单资源文件
        menuInflater.inflate(R.menu.layout_menu,menu)//有两个参数，解析完了放在menu中
        return super.onCreateOptionsMenu(menu)
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        item.icon = if (isLinearLayout){
            getDrawable(R.drawable.grid)
        }else{
            getDrawable(R.drawable.linear)
        }
        isLinearLayout = !isLinearLayout
        changeLayout()
        return true
    }
}

















