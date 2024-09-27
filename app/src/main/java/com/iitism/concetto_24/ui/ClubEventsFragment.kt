package com.iitism.concetto_24.ui

import android.app.Dialog
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.iitism.concetto_24.R
import com.iitism.concetto_24.adapter.EventAdapter
import com.iitism.concetto_24.databinding.FragmentClubEventsBinding
import com.iitism.concetto_24.models.EventsData
import java.io.InputStream

class ClubEventsFragment : Fragment() {

    private var _binding: FragmentClubEventsBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: EventAdapter
    private lateinit var dialog: Dialog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentClubEventsBinding.inflate(inflater, container, false)
        dialog = Dialog(requireActivity())
        dialog.setContentView(R.layout.progress_bar)
        dialog.setCancelable(false)
        val layoutParams = WindowManager.LayoutParams().apply {
            width = WindowManager.LayoutParams.MATCH_PARENT
            height = WindowManager.LayoutParams.MATCH_PARENT
        }
        dialog.window?.attributes = layoutParams
        if (dialog.window != null) {
            dialog.window!!.setBackgroundDrawable(
                ColorDrawable(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.bg
                    )
                )
            )
            dialog.window!!.setBackgroundDrawableResource(R.color.transparent)

        }
        val eventData = getClubEventData()

        binding.recyclerViewClubEvents.layoutManager = LinearLayoutManager(context)
        binding.recyclerViewClubEvents.setHasFixedSize(true)
        adapter = EventAdapter(eventData, requireContext())
        binding.recyclerViewClubEvents.adapter = adapter
        return binding.root
    }

    fun getClubEventData(): Array<EventsData> {

            val assetManager = requireContext().assets
            val inputStream: InputStream = assetManager.open("club_events.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()

            val json = String(buffer, Charsets.UTF_8)
            val gson = Gson()
            val clubEvents = gson.fromJson(json, Array<EventsData>::class.java)
        Log.d("events",clubEvents.toString())
            return clubEvents


    }
}
