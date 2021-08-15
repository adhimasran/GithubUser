package com.adhi.githubuser

data class User(
    var photo: Int,
    var name: String,
    var username: String,
    var location: String,
    var repository: Int,
    var company: String,
    var follower: Int,
    var following: Int
)
