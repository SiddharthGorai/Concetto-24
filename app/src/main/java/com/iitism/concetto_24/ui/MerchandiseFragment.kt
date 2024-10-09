package com.iitism.concetto_24.ui

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
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.iitism.concetto_24.R
import com.iitism.concetto_24.databinding.FragmentHomeBinding
import com.iitism.concetto_24.databinding.FragmentMerchandiseBinding
import com.iitism.concetto_24.services.GoogleFormApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream


class MerchandiseFragment : Fragment() {
    private lateinit var openFormButton: Button
    private var imagePager: ViewPager2?=null
    private lateinit var nameEt: EditText
    private lateinit var emailEt: EditText
    private lateinit var admissionEt: EditText
    private lateinit var hostelEt: Spinner
    private lateinit var roomEt: EditText
    private lateinit var contactEt: EditText
    private lateinit var sizeEt: Spinner
    private lateinit var hostelSpinner:Spinner
    private lateinit var sizeSpinner: Spinner
    private lateinit var imageView: ImageView
    private var selectedImageUri: Uri?=null
    val PICK_IMAGE_REQUEST = 1
    var selectedImageFile: File? = null
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://docs.google.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val api = retrofit.create(GoogleFormApi::class.java)

    private var _binding: FragmentMerchandiseBinding? = null
    private val binding get() = _binding!!

    var imageList = listOf(
        R.drawable.tshirt,
        R.drawable.tshirt_front,
        R.drawable.tshirt_back,
        R.drawable.measurement_chart,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMerchandiseBinding.inflate(layoutInflater)
        return binding.root
//        imageView=view.findViewById(R.id.payment_screenshot)
//        emailEt=view.findViewById(R.id.etEmail)
//        admissionEt=view.findViewById(R.id.etAdm)
//        hostelEt=view.findViewById(hostel_spinner)
//        roomEt=view.findViewById(R.id.etRoom)
//        sizeEt=view.findViewById(size_spinner)
//        contactEt=view.findViewById(R.id.etcontact)
//        val getImage = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
//            uri?.let {
//                selectedImageUri = it
//                val bitmap = MediaStore.Images.Media.getBitmap(requireContext().contentResolver, it)
//                imageView.setImageBitmap(bitmap)
//            }
//        }
//        imageView.setOnClickListener {
//            pickImageFromGallery()
//        }
//        hostelSpinner=view.findViewById(hostel_spinner)
//        sizeSpinner=view.findViewById(size_spinner)

//        btnPlace.setOnClickListener {
//            val name=nameEt.text.toString()
//            val adm=admissionEt.text.toString()
//            val email=emailEt.text.toString()
//            val hostel=hostelEt.selectedItem.toString()
//            val room=roomEt.text.toString()
//            val contact=contactEt.text.toString()
//            val size=sizeEt.selectedItem.toString()
//            val call=api.sendFormData(name,email,adm,hostel,room,contact,size,selectedImageFile)
//            call.enqueue(object:Callback<Void> {
//                override fun onResponse(call: Call<Void>, response: Response<Void>) {
//                    try {
//                        if (response.isSuccessful) {
//                            Toast.makeText(requireContext(), "Successful", Toast.LENGTH_SHORT).show()
//                        } else {
//                            Log.e(selectedImageUri.toString(), "onResponse: ")
//                            Toast.makeText(requireContext(), "unsuccessful", Toast.LENGTH_SHORT).show()
//                        }
//                    } catch (e: Exception) {
//                        Toast.makeText(requireContext(), "Error: ${e.message}", Toast.LENGTH_SHORT).show()
//                    }
//                }
//
//                override fun onFailure(call: Call<Void>, t: Throwable) {
//                    try {
//                        Toast.makeText(requireContext(), "Error: ${t.message}", Toast.LENGTH_SHORT).show()
//                    } catch (e: Exception) {
//                        Toast.makeText(requireContext(), "Error: ${e.message}", Toast.LENGTH_SHORT).show()
//                    }
//                }
//
//
//            })
//        }
//        HostelSpinner()
//        SizeSpinner()

    }
//    private fun pickImageFromGallery() {
//        val intent = Intent(Intent.ACTION_PICK)
//        intent.type = "image/*" // Only allow image selection
//        startActivityForResult(intent, PICK_IMAGE_REQUEST)
//    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    imagePager = view.findViewById<ViewPager2>(R.id.view_pager_carousel)

    val adapter = ImagePagerAdapter(imageList)
    imagePager?.adapter = adapter
    startImageSliderTimer()
//        nameEt=view.findViewById(R.id.etName)
    val btnPlace=view.findViewById<Button>(R.id.PlaceOrder)


//        startAutoScroll()


    btnPlace.setOnClickListener {
        openGoogleForm()
    }
    }
    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
            val imageUri: Uri? = data.data
            imageUri?.let {
                selectedImageFile = uriToFile(it)

                if (selectedImageFile != null) {
                    imageView.setImageURI(it)  // Set the image to the ImageView

                    Toast.makeText(requireContext(), "Image saved at: ${selectedImageFile!!.absolutePath}", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    // Convert Uri to File
    fun uriToFile(uri: Uri): File? {
        val contentResolver: ContentResolver = requireContext().contentResolver
        val tempFile = File.createTempFile("selected_image", ".jpg", requireContext().cacheDir)

        try {
            val inputStream: InputStream? = contentResolver.openInputStream(uri)
            val outputStream = FileOutputStream(tempFile)

            inputStream?.use { input ->
                outputStream.use { output ->
                    input.copyTo(output)
                }
            }
            return tempFile
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return null
    }
    private fun SizeSpinner() {
        val sizes = listOf(
            "XS",
            "S",
            "M",
            "L",
            "XL",
            "XXL"
        )
        val adapter = ArrayAdapter(
            requireContext(),
            R.layout.spinner_item,
            sizes
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Apply the adapter to the spinner
        sizeSpinner.adapter = adapter
        sizeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                val selectedHotel = parent.getItemAtPosition(position).toString()
                //Toast.makeText(requireContext(), "Selected: $selectedHotel", Toast.LENGTH_SHORT)
                //.show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Another callback if nothing is selected
            }

        }
    }
    private fun HostelSpinner() {
        val hotelNames = listOf(
            "Amber",
            "Aquamarine",
            "Jasper",
            "Sapphire",
            "Topaz",
            "Rosaline",
            "Ruby",
            "Diamond",
            "Emarald",
            "Opal",
            "International Hostel",
            "Others"
        )
        val adapter = ArrayAdapter(
            requireContext(),
            R.layout.spinner_item,
            hotelNames
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        hostelSpinner.adapter = adapter
        hostelSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                val selectedHotel = parent.getItemAtPosition(position).toString()
                //Toast.makeText(requireContext(), "Selected: $selectedHotel", Toast.LENGTH_SHORT)
                //.show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Another callback if nothing is selected
            }

        }
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

