package com.iitism.concetto_24.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.iitism.concetto_24.ViewModel.CoreTeamViewModel
import com.iitism.concetto_24.adapter.CoreTeamAdapter
import com.iitism.concetto_24.databinding.FragmentCoreTeamBinding

class CoreTeamFragment : Fragment() {
    private lateinit var viewModel: CoreTeamViewModel
    private lateinit var binding: FragmentCoreTeamBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCoreTeamBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvCoreTeam.layoutManager = LinearLayoutManager(context)
        binding.rvCoreTeam.setHasFixedSize(true)

        viewModel = CoreTeamViewModel(requireContext())
        viewModel.getCoreTeamList()

        val itemAdapter = CoreTeamAdapter(viewModel.coreTeamList)
        binding.rvCoreTeam.adapter = itemAdapter
    }
}