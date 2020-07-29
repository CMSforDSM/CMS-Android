package com.dsm.cms.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dsm.cms.databinding.ItemMemberBinding
import com.dsm.cms.domain.entity.Post

class MemberAdapter() : RecyclerView.Adapter<MemberAdapter.MemberViewHolder>() {
    private var items: List<String> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemberViewHolder {
        return MemberViewHolder(
            ItemMemberBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MemberViewHolder, position: Int) {
        holder.bind(items[position])
    }


    fun setList(data: List<String>) {
        items = data
        notifyDataSetChanged()
    }

    inner class MemberViewHolder(private val binding: ItemMemberBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(stdInfo: String) {
            val splitStdInfo = stdInfo.split("-")
            binding.memberName.text = splitStdInfo[0]
            binding.memberNumber.text = splitStdInfo[1]
        }
    }
}