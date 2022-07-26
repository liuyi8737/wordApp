package com.example.wordapp

import android.annotation.SuppressLint
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class LettersAddapter: RecyclerView.Adapter<LettersAddapter.MyViewHolder>() {
    private var letterList = emptyList<Char>()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newData: List<Char>){
        letterList = newData
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return letterList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.letter_layout,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val letter = letterList[position]
        holder.letterBtn.text = "$letter"
        holder.letterBtn.setOnClickListener {
            //显式意图
            val context = holder.letterBtn.context
            val intent = Intent(context,WordsActivity::class.java)

            intent.putExtra("letter",letter.toString())
            context.startActivity(intent)
        }
    }

    class MyViewHolder(view: View):RecyclerView.ViewHolder(view){
        val letterBtn = itemView.findViewById<Button>(R.id.button)
    }
}