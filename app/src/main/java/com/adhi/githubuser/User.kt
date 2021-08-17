package com.adhi.githubuser

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val photo: Int,
    val name: String,
    val username: String,
    val location: String,
    val repository: Int,
    val company: String,
    val follower: Int,
    val following: Int
) : Parcelable
