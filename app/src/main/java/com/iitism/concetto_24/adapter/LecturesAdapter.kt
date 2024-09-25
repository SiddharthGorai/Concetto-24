package com.iitism.concetto_24.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.iitism.concetto_24.Data.LectureData
import com.iitism.concetto_24.R

class LecturesAdapter(private val dataList: List<LectureData>): RecyclerView.Adapter<LecturesAdapter.LecturesViewHolder>() {
    inner class LecturesViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LecturesViewHolder {
        val viewHolder = LayoutInflater.from(parent.context).inflate(R.layout.card_item,parent,false)
        return LecturesViewHolder(viewHolder)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: LecturesViewHolder, position: Int) {
        val item = dataList[position] // Get the LectureItem

        val imageView = holder.itemView.findViewById<ImageView>(R.id.cardImage)
        val title = holder.itemView.findViewById<TextView>(R.id.cardTitle)

        Glide.with(holder.itemView.context).load(item.imageUrl) // Load image URL
            .centerCrop()
            .into(imageView)

        title.text = item.title
    }
}