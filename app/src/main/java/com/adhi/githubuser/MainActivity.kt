package com.adhi.githubuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.adhi.githubuser.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var list: ArrayList<User> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvUsers.setHasFixedSize(true)

        addUser()
        showRecyclerCardView()
    }

    private fun addUser() {
        val profile = resources.obtainTypedArray(R.array.avatar)
        val name = resources.getStringArray(R.array.name)
        val username = resources.getStringArray(R.array.username)
        val location = resources.getStringArray(R.array.location)
        val repository = resources.getStringArray(R.array.repository)
        val company = resources.getStringArray(R.array.company)
        val follower = resources.getStringArray(R.array.followers)
        val following = resources.getStringArray(R.array.following)

        for (position in username.indices) {
            val user = User(
                profile.getResourceId(position, -1),
                name[position],
                username[position],
                location[position],
                repository[position].toInt(),
                company[position],
                follower[position].toInt(),
                following[position].toInt()
            )
            list.add(user)
        }
    }

    private fun showRecyclerCardView() {
        binding.rvUsers.layoutManager = LinearLayoutManager(this)
        val cardViewUser = CardViewUser(list)
        binding.rvUsers.adapter = cardViewUser
    }
}