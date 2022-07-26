package com.example.wordapp

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import java.net.URL

class WordsAddapter: RecyclerView.Adapter<WordsAddapter.MyViewHolder>() {
    private var wordsList = emptyList<String>()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newData: List<String>){
        wordsList = newData
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return wordsList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.letter_layout,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val word = wordsList[position]
        holder.letterBtn.text = "$word"
        holder.letterBtn.setOnClickListener {
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://fanyi.baidu.com/#en/zh/$word")
            )
            holder.letterBtn.context.startActivity(intent)
        }
    }

    class MyViewHolder(view: View):RecyclerView.ViewHolder(view){
        val letterBtn = itemView.findViewById<Button>(R.id.button)
    }
}