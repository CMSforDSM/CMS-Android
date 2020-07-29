package com.dsm.cms.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dsm.cms.databinding.ItemResumeBinding
import com.dsm.cms.domain.entity.Post
import com.dsm.cms.viewModel.MainViewModel

class MainResumeAdapter(
    private val viewModel: MainViewModel
) :
    RecyclerView.Adapter<MainResumeAdapter.MainResumeViewHolder>() {
    private var items: List<Post> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainResumeViewHolder {
        return MainResumeViewHolder(
            ItemResumeBinding.inflate(
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

    inner class MainResumeViewHolder(private val binding: ItemResumeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(resume: Post) {
            binding.resume = resume

            binding.btnScoutMarket.setOnClickListener {
                viewModel.offerScout(resume.writer)
            }
        }
    }
}