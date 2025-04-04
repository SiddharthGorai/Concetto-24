package com.iitism.concetto_24.ui

import android.annotation.SuppressLint
import android.app.Activity
import android.content.ContentResolver
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.iitism.concetto_24.R
import com.iitism.concetto_24.services.GoogleFormApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream


class MerchandiseFragment : Fragment() {
    private var imagePager: ViewPager2?=null
    private lateinit var hostelSpinner:Spinner
    private lateinit var sizeSpinner: Spinner
    private lateinit var imageView: ImageView
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://docs.google.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    var imageList = listOf(
        R.drawable.tshirt,
        R.drawable.tshirt_front,
        R.drawable.tshirt_back,
        R.drawable.measurement_chart,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_merchandise, container, false)
        imagePager = view.findViewById<ViewPager2>(R.id.view_pager_carousel_merch)
        val adapter = ImagePagerAdapter(imageList)
        imagePager?.adapter = adapter
        startImageSliderTimer()
        val btnPlace=view.findViewById<Button>(R.id.PlaceOrder)
        btnPlace.setOnClickListener {
            openGoogleForm()
        }
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
            val imageView: ImageView = itemView.findViewById(R.id.pageImage)

            fun bind(imageRes: Int) {
                Glide.with(itemView.context)
                    .load(imageRes)
                    .into(imageView)
            }
        }
    }

}

