package com.iitism.concetto_24.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.iitism.concetto_24.R

class ImagePagerAdapter (
    private val imageUrls: List<String>,
    private val fragment: Fragment
    ) : RecyclerView.Adapter<ImagePagerAdapter.ImageViewHolder>() {

        class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val imageView: ImageView = itemView.findViewById(R.id.imageView)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_image_pager, parent, false)
            return ImageViewHolder(view)
        }

        override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
            val imageUrl = imageUrls[position]
            Glide.with(fragment)
                .load(imageUrl)
                .into(holder.imageView)
        }

        override fun getItemCount(): Int {
            return imageUrls.size
        }
}