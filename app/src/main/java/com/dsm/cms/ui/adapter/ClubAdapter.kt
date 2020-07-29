package com.dsm.cms.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dsm.cms.databinding.ItemClubBinding
import com.dsm.cms.domain.entity.Club
import com.dsm.cms.ui.activity.ClubActivity

class ClubAdapter : RecyclerView.Adapter<ClubAdapter.ClubViewHolder>() {
    private var items: List<Club> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClubViewHolder {
        return ClubViewHolder(
            ItemClubBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ClubViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun setList(data: List<Club>) {
        items = data
        notifyDataSetChanged()
    }

    inner class ClubViewHolder(private val binding: ItemClubBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(club: Club) {
            binding.club = club
            binding.btnItem.visibility = View.INVISIBLE

            binding.layoutItemClub.setOnClickListener {
                itemView.context.apply {
                    val intent = Intent(this, ClubActivity::class.java)
                    intent.putExtra("club", club)
                    startActivity(intent)
                }
            }
        }
    }
}