package com.adhi.githubuser

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adhi.githubuser.databinding.CardViewUserBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class CardViewUser (private val listUser: ArrayList<User>): RecyclerView.Adapter<CardViewUser.CardViewHolder>() {

    inner class CardViewHolder(val binding: CardViewUserBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding = CardViewUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val user = listUser[position]

        Glide.with(holder.itemView.context)
            .load(user.photo)
            .apply(RequestOptions().override(350, 350))
            .into(holder.binding.imgPhoto)

        holder.binding.tvName.text = user.name
        holder.binding.tvFollowers.text = user.follower
        holder.binding.tvRepo.text = user.repository
    }

    override fun getItemCount(): Int = listUser.size
}