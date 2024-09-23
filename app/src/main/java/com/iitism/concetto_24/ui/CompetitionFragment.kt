package com.iitism.concetto_24.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.iitism.concetto_24.R
import com.iitism.concetto_24.adapter.CompetitionAdapter
import com.iitism.concetto_24.data.CompetitionDataModel

class CompetitionFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var competitionAdapter: CompetitionAdapter
    private var competitionList = mutableListOf<CompetitionDataModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_competition, container, false)

        recyclerView = view.findViewById(R.id.recyclerView_competitions)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // dummy data
        competitionList.add(
            CompetitionDataModel(
                "Competition 1",
                "https://res.cloudinary.com/dnywj3xrl/image/upload/v1725973132/IMG-20240910-WA0054_p41az0.jpg",
                "https://forms.gle/9PJ6ytPU6HG1E7mZ9",
                "https://forms.gle/9PJ6ytPU6HG1E7mZ9"
            )
        )
        competitionList.add(
            CompetitionDataModel(
                "Competition 2",
                "https://res.cloudinary.com/dnywj3xrl/image/upload/v1725973121/IMG-20240910-WA0046_b92t9n.jpg",
                "https://forms.gle/9PJ6ytPU6HG1E7mZ9",
                "https://forms.gle/9PJ6ytPU6HG1E7mZ9"
            )
        )

        competitionAdapter = CompetitionAdapter(competitionList, requireContext())
        recyclerView.adapter = competitionAdapter

        return view
    }
}
