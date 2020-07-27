package com.dsm.cms.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dsm.cms.databinding.ItemMarketBinding
import com.dsm.cms.domain.entity.Post

class MainResumeAdapter :
    RecyclerView.Adapter<MainResumeAdapter.MainResumeViewHolder>() {
    private var items: List<Post> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainResumeViewHolder {
        return MainResumeViewHolder(
            ItemMarketBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MainResumeViewHolder, position: Int) {
        holder.bind(items[position])
    }


    fun setList(data: List<Post>) {
        items = data
        notifyDataSetChanged()
    }

    inner class MainResumeViewHolder(private val binding: ItemMarketBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(resume: Post) {
            binding.resume = resume

            binding.btnScoutMarket.isEnabled
        }
    }
}