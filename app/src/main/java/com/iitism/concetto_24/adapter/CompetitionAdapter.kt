package com.iitism.concetto_24.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.iitism.concetto_24.R
import com.iitism.concetto_24.data.CompetitionDataModel

class CompetitionAdapter(private val competitionList: List<CompetitionDataModel>, val context: Context) :
    RecyclerView.Adapter<CompetitionAdapter.CompetitionViewHolder>() {

    inner class CompetitionViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val competitionImage: ImageView = view.findViewById(R.id.competition_img)
        val competitionName: TextView = view.findViewById(R.id.competition_name)
        val rulebookButton: Button = view.findViewById(R.id.btn_rulebook)
        val registerButton: Button = view.findViewById(R.id.btn_register)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompetitionViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.competition_card_view, parent, false)
        return CompetitionViewHolder(view)
    }

    override fun onBindViewHolder(holder: CompetitionViewHolder, position: Int) {
        val competition = competitionList[position]

        holder.competitionName.text = competition.competitionName
        Glide.with(context)
            .load(competition.imageUrl)
            .placeholder(R.drawable.campus_amb2)
            .into(holder.competitionImage)

        holder.rulebookButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(competition.rulebookLink))
            context.startActivity(intent)
        }

        holder.registerButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(competition.registerLink))
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return competitionList.size
    }
}
