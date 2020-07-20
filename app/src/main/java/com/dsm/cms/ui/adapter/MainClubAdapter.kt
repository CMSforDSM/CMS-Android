package com.dsm.cms.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dsm.cms.databinding.ItemClubBinding
import com.dsm.cms.domain.entity.Club

class MainClubAdapter : RecyclerView.Adapter<MainClubAdapter.MainClubViewHolder>() {
    private var items: List<Club> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainClubViewHolder {
        return MainClubViewHolder(
            ItemClubBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MainClubViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun setList(data: List<Club>) {
        items = data
        notifyDataSetChanged()
    }

    inner class MainClubViewHolder(private val binding: ItemClubBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(club: Club) {
            Glide.with(itemView.context).load(club.logo).into(binding.ivClubIconItem)
            binding.tvClubNameItem.text = club.clubName
            binding.tvClubInfoItem.text = club.introduce
        }
    }
}