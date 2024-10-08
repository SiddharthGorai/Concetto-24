package com.iitism.concetto_24.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.iitism.concetto_24.Data.GuestTalkData
import com.iitism.concetto_24.R
import com.iitism.concetto_24.adapter.GuestTalkAdapter
import com.iitism.concetto_24.databinding.FragmentGuestTalkBinding

class GuestTalkFragment : Fragment() {

    private var _binding: FragmentGuestTalkBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentGuestTalkBinding.inflate(layoutInflater)
        return binding!!.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val guestData = listOf(
            GuestTalkData(
            "https://res.cloudinary.com/dbzyamccb/image/upload/v1727184530/Tanu-Jain_nrx027.webp",
            "Dr.Tanu Jain","Dr. Tanu Jain’s inspiring journey spans from being a medical doctor to an IAS officer, where she dedicated seven years to healthcare reforms, education, and rural development. After successfully clearing the UPSC Civil Services Examination, she chose to resign to engage directly with societal issues. Channeling her passion into social initiatives, Dr. Jain worked with NGOs focused on healthcare and women’s empowerment. She also embraced motivational speaking, inspiring students and aspiring civil servants with her authentic insights. As an author, she shares wisdom on personal development and resilience, motivating others to pursue their dreams and make a positive impact. Dr. Tanu Jain exemplifies courage and selflessness, leaving a lasting legacy of service and inspiration"),
            GuestTalkData(
                "https://res.cloudinary.com/dbzyamccb/image/upload/v1727184502/Anubhav-Dubey-Chai-Sutta-Bar_tmdq3q.jpg",
                "Anubhav Dubey","Anubhav Dubey is a young entrepreneur and co-founder of Chai Sutta Bar, a pioneering tea franchise that has transformed India's tea industry. Launched in 2016, the brand combines tradition with modern business strategies by serving tea in eco-friendly kulhads (clay cups), promoting sustainability and authenticity. Starting with minimal capital, Dubey's focus on creating affordable, welcoming spaces quickly gained popularity among students and professionals. Under his leadership, Chai Sutta Bar has grown into a global brand, symbolizing youth-driven entrepreneurship while supporting social causes like potter employment and environmental responsibility."),
            GuestTalkData(
                "https://res.cloudinary.com/dbzyamccb/image/upload/v1727184530/maxresdefault_e3u9to.jpg",
                "Dr. Vijendra Singh Chauhan","Dr. Vijendra Singh Chauhan, an Associate Professor of Hindi at Zakir Husain Delhi College, is a visionary leader in education and research. Renowned for his innovative contributions, he adeptly integrates modern methodologies and technology into his teaching. His work promotes interdisciplinary approaches, driving impactful solutions that bridge academic theory and practical application. Dr. Chauhan’s insightful examination of the UPSC Interview highlights his commitment to advancing knowledge and fostering growth in his field."),
            GuestTalkData("https://res.cloudinary.com/dbzyamccb/image/upload/v1727186021/035cf7358a3958cf336e1706ffd3e70f_ciut1f.jpg",
                "Deepanshu Raj","Meet Iqlipse Nova: The Multifaceted Creator  Deepanshu Raj, known as Iqlipse Nova, was born on September 16, 1998, in Rajgir, Bihar. A graduate of IIT Delhi, he holds a dual degree in Chemical Engineering (B.Tech + M.Tech), but his heart beats for creativity. From a young age, he dreamt of filmmaking and music, ultimately convincing his parents to let him chase his passion after graduation. Now a vibrant YouTuber and social media influencer, Iqlipse captivates audiences with his music videos and lifestyle vlogs, proving that true success lies in following one’s dreams."))
        val recyclerView = view.findViewById<RecyclerView>(R.id.rvGuestTalk)
        recyclerView.adapter = GuestTalkAdapter(guestData,requireContext())
        recyclerView.layoutManager = LinearLayoutManager(context)





    }
}
//
//        val images = arrayOf(
//            "https://res.cloudinary.com/dbzyamccb/image/upload/v1727184530/Tanu-Jain_nrx027.webp",
//            "https://res.cloudinary.com/dbzyamccb/image/upload/v1727184502/Anubhav-Dubey-Chai-Sutta-Bar_tmdq3q.jpg",
//            "https://res.cloudinary.com/dbzyamccb/image/upload/v1727184530/maxresdefault_e3u9to.jpg",
//            "https://res.cloudinary.com/dbzyamccb/image/upload/v1727186021/035cf7358a3958cf336e1706ffd3e70f_ciut1f.jpg",
//            "https://res.cloudinary.com/dbzyamccb/image/upload/v1727193140/OIP_ecic00.jpg"
//        )
//        binding?.viewPagerLectures?.adapter = HomeCarouselAdapter(images)
//
//        val compositePageTransformer = CompositePageTransformer()
//        compositePageTransformer.addTransformer(MarginPageTransformer((40 * Resources.getSystem().displayMetrics.density).toInt()))
//        compositePageTransformer.addTransformer { page, position ->
//            val r = 1 - abs(position)
//            page.scaleY = (0.80f + r * 0.20f)
//        }
//        binding!!.viewPagerLectures.setPageTransformer(compositePageTransformer)
//
//        addDotsIndicator(images.size)
//        binding!!.viewPagerLectures.registerOnPageChangeCallback(object :
//            ViewPager2.OnPageChangeCallback() {
//            override fun onPageSelected(position: Int) {
//                super.onPageSelected(position)
//                updateDots(position)
//            }
//        })
//
////        startAutoScroll()
//
//        binding!!.viewPagerLectures.registerOnPageChangeCallback(object :
//            ViewPager2.OnPageChangeCallback() {
//            override fun onPageSelected(position: Int) {
//                currentPage = position
//            }
//        })
//
//
//        val images2= listOf(
//            "https://res.cloudinary.com/dbzyamccb/image/upload/v1727184530/maxresdefault_e3u9to.jpg",
//            "Dr.Vijendra Singh Chauhan",
//            "https://res.cloudinary.com/dbzyamccb/image/upload/v1727184502/Anubhav-Dubey-Chai-Sutta-Bar_tmdq3q.jpg",
//            "Anubhav Dubey",
//            "https://res.cloudinary.com/dbzyamccb/image/upload/v1727184530/Tanu-Jain_nrx027.webp",
//            "Dr. Tanu Jain",
//            "https://res.cloudinary.com/dbzyamccb/image/upload/v1727186021/035cf7358a3958cf336e1706ffd3e70f_ciut1f.jpg",
//            "Iqlipse Nova"
//        )
//        val lectureItems = mutableListOf<LectureData>()
//        for (i in images2.indices step 2) {
//            lectureItems.add(LectureData(images2[i], images2[i + 1]))
//        }
//
//        binding?.viewPagerLectures2?.adapter = LecturesAdapter(lectureItems)
//
//        val compositePageTransformer2 = CompositePageTransformer()
//        compositePageTransformer2.addTransformer(MarginPageTransformer((40 * Resources.getSystem().displayMetrics.density).toInt()))
//        compositePageTransformer2.addTransformer { page, position ->
//            val r = 1 - abs(position)
//            page.scaleY = (0.80f + r * 0.20f)
//        }
//        binding!!.viewPagerLectures2.setPageTransformer(compositePageTransformer2)
//
//        //addDotsIndicator(images.size)
//        binding!!.viewPagerLectures2.registerOnPageChangeCallback(object :
//            ViewPager2.OnPageChangeCallback() {
//            override fun onPageSelected(position: Int) {
//                super.onPageSelected(position)
//                //updateDots(position)
//            }
//        })
//
////        startAutoScroll()
//
//        binding!!.viewPagerLectures2.registerOnPageChangeCallback(object :
//            ViewPager2.OnPageChangeCallback() {
//            override fun onPageSelected(position: Int) {
//                currentPage2 = position
//            }
//        })



    //    private fun addToList(image:Int)
//    {
//        imagesList.add(image)
//    }
//
//    private fun postToList(){
//        for(i in 1..5){
//            addToList(R.mipmap.ic_launcher_round)
//        }
//    }

//    private fun updateDots(position: Int) {
//        val childCount = binding!!.dotLayout.childCount
//        for (i in 0 until childCount) {
//            val dot = binding!!.dotLayout.getChildAt(i) as ImageView
//            val drawableId =
//                if (i == position) R.drawable.indicator_active else R.drawable.indicator_inactive
//            dot.setImageDrawable(ContextCompat.getDrawable(requireContext(), drawableId))
//        }
//    }
//
//    private fun addDotsIndicator(size: Int) {
//        val dots = arrayOfNulls<ImageView>(size)
//        for (i in 0 until size) {
//            dots[i] = ImageView(requireContext())
//            dots[i]?.setImageDrawable(
//                ContextCompat.getDrawable(
//                    requireContext(),
//                    R.drawable.indicator_inactive
//                )
//            )
//            val params = LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.WRAP_CONTENT,
//                LinearLayout.LayoutParams.WRAP_CONTENT
//            )
//            params.setMargins(8, 0, 8, 0)
//            binding!!.dotLayout.addView(dots[i], params)
//        }
//        dots[0]?.setImageDrawable(
//            ContextCompat.getDrawable(
//                requireContext(),
//                R.drawable.indicator_active
//            )
//        )
//    }
//}