package com.iitism.concetto_24.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.iitism.concetto_24.R
import com.iitism.concetto_24.R.id.tvReferalCode
import com.iitism.concetto_24.utils.SharedPrefsHelper


class ProfileFragment : Fragment() {
    private lateinit var tvName: TextView
    private lateinit var tvEmail: TextView
    private lateinit var tvReferallCode: TextView
    private lateinit var btnLogout: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_profile, container, false)
        tvName = view.findViewById(R.id.tvName)
        tvEmail = view.findViewById(R.id.tvEmail)
        tvReferallCode = view.findViewById<TextView>(tvReferalCode)
        btnLogout = view.findViewById<Button>(R.id.btnLogout)
        loadUserData()
        btnLogout.setOnClickListener {
            logoutUser()
        }
        return view
    }
    private fun loadUserData() {
        val sharedPref:SharedPrefsHelper= SharedPrefsHelper(requireContext())
        val user=sharedPref.getUser()
        val name=user?.username.toString()
        val email=user?.email.toString()
        // Set the data to the TextViews
        tvName.text = name
        tvEmail.text = email
        tvReferallCode.text=sharedPref.getReferral().toString()
    }
    private fun logoutUser() {
        SharedPrefsHelper(requireContext()).clear()
        requireActivity().finish()
        startActivity(Intent(requireContext(), MainActivity::class.java))
    }
}