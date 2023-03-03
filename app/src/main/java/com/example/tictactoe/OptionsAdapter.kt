package com.example.tictactoe

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class OptionsAdapter(private val list: List<Options>) :
    RecyclerView.Adapter<OptionsAdapter.OptionsViewHolder>() {

    class OptionsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val btnChooseOption: Button = itemView.findViewById(R.id.btnChooseOption)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.options, parent, false)
        return OptionsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: OptionsViewHolder, position: Int) {
        val currentItem = list[position]
        holder.btnChooseOption.background =
            ContextCompat.getDrawable(holder.itemView.context, currentItem.background)
        holder.btnChooseOption.text = currentItem.title
    }

    override fun getItemCount(): Int {
        return list.size
    }
}