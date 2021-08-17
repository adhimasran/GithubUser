package com.adhi.githubuser

import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.adhi.githubuser.databinding.ViewDetailUserBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ViewDetailUser : AppCompatActivity() {
    private lateinit var binding: ViewDetailUserBinding

    companion object {
        const val userData = "user_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ViewDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = intent.getParcelableExtra<User>(userData) as User

        Glide.with(this)
            .load(user.photo)
            .apply(RequestOptions().override(350, 350))
            .into(binding.imgPhoto)

        binding.tvName.text = user.name
        binding.tvUsername.text = user.username
        binding.tvCompany.text = user.company
        binding.tvLocation.text = user.location
        binding.tvRepo.text = user.repository.toString()
        binding.tvFollowers.text = user.follower.toString()
        binding.tvFollowing.text = user.following.toString()

        val actionBar: ActionBar? = supportActionBar
        actionBar?.title = user.name
    }
}