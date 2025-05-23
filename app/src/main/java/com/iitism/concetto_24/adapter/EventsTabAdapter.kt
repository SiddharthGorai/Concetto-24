package com.iitism.concetto_24.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.iitism.concetto_24.ui.ClubEventsFragment
import com.iitism.concetto_24.ui.DepartmentalEventsFragment

class EventsTabAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return 2 // Number of tabs
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ClubEventsFragment()  // First tab fragment
            1 -> DepartmentalEventsFragment()  // Second tab fragment
            else -> ClubEventsFragment()
        }
    }
}
