package com.dsm.cms.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dsm.cms.databinding.ItemRecruitmentBinding
import com.dsm.cms.domain.entity.Post

class MainRecruitmentAdapter :
    RecyclerView.Adapter<MainRecruitmentAdapter.MainRecruitementViewHolder>() {
    private var items: List<Post> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainRecruitementViewHolder {
        return MainRecruitementViewHolder(
            ItemRecruitmentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MainRecruitementViewHolder, position: Int) {
        holder.bind(items[position])
    }


    fun setList(data: List<Post>) {
        items = data
        notifyDataSetChanged()
    }

    inner class MainRecruitementViewHolder(private val binding: ItemRecruitmentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(post: Post) {
            binding.post = post
        }
    }
}