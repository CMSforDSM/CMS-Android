package com.dsm.cms.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dsm.cms.databinding.ItemRecruitmentBinding
import com.dsm.cms.domain.entity.Post

class MainPostAdapter :
    RecyclerView.Adapter<MainPostAdapter.MainPostViewHolder>() {
    private var items: List<Post> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainPostViewHolder {
        return MainPostViewHolder(
            ItemRecruitmentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MainPostViewHolder, position: Int) {
        holder.bind(items[position])
    }


    fun setList(data: List<Post>) {
        items = data
        notifyDataSetChanged()
    }

    inner class MainPostViewHolder(private val binding: ItemRecruitmentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(post: Post) {
            binding.post = post
        }
    }
}