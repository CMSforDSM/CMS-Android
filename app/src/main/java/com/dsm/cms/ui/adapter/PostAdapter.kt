package com.dsm.cms.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dsm.cms.databinding.ItemRecruitmentBinding
import com.dsm.cms.domain.entity.Post
import com.dsm.cms.ext.setDateManually
import com.dsm.cms.ui.activity.PostActivity

class PostAdapter :
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
    private var items: List<Post> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(
            ItemRecruitmentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun setList(data: List<Post>) {
        items = data
        notifyDataSetChanged()
    }

    inner class PostViewHolder(private val binding: ItemRecruitmentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(post: Post) {
            binding.post = post

            binding.layoutRecruitment.setOnClickListener {
                itemView.context.apply {
                    val intent = Intent(this, PostActivity::class.java)
                    post.dateTime = setDateManually(post.dateTime)
                    intent.putExtra("post", post)
                    startActivity(intent)
                }
            }
        }
    }
}