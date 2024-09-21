package com.iitism.concetto_24.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.iitism.concetto_24.R


class MerchandiseFragment : Fragment() {
    private lateinit var openFormButton: Button
    private var imagePager: ViewPager2?=null
    var imageList = listOf(
        R.drawable.tshirt,
        R.drawable.tshirt,
        R.drawable.tshirt,
        R.drawable.tshirt,
        R.drawable.tshirt,
        R.drawable.tshirt
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_merchandise, container, false)
        openFormButton = view.findViewById<Button>(R.id.BtnOrder)
        openFormButton.setOnClickListener {
            openGoogleForm()
        }
        imagePager = view.findViewById<ViewPager2>(R.id.view_pager_carousel)

        val adapter = ImagePagerAdapter(imageList)
        imagePager?.adapter = adapter
        startImageSliderTimer()
        return view
    }
    private fun openGoogleForm() {
        val formUrl = "https://forms.gle/nwcyLA5kh28teKN39"
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(formUrl)
        startActivity(intent)
    }
    private fun startImageSliderTimer() {
        val handler = Handler()
        val updateImageSliderTask = object : Runnable {
            override fun run() {
                val currentPage = imagePager?.currentItem
                var nextPage = currentPage?.plus(1)
                if (nextPage != null) {
                    if (nextPage >= imageList.size) {
                        nextPage = 0
                    }
                }
                if (nextPage != null) {
                    imagePager?.currentItem = nextPage
                }
                handler.postDelayed(this, 4000)
            }
        }
        handler.postDelayed(updateImageSliderTask, 4000)
    }
    class ImagePagerAdapter(private val imageList: List<Int>) :
        RecyclerView.Adapter<ImagePagerAdapter.ImagePagerViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagePagerViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_image_pager, parent, false)
            return ImagePagerViewHolder(view)
        }

        override fun onBindViewHolder(holder: ImagePagerViewHolder, position: Int) {
            val imageRes = imageList[position]
            holder.bind(imageRes)
        }

        override fun getItemCount(): Int {
            return imageList.size
        }

        inner class ImagePagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val imageView: ImageView = itemView.findViewById(R.id.imageView)

            fun bind(imageRes: Int) {
                Glide.with(itemView.context)
                    .load(imageRes)
                    .into(imageView)
            }
        }
    }


}

