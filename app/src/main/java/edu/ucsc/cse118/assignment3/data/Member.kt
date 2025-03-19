package edu.ucsc.cse118.assignment3.data

import kotlinx.serialization.Serializable

@Serializable
data class Member (

    // Tongze helped me update this
    val id: String,
    val name: String,
    val role: String? = " ",
    val accessToken:  String? = " "
)
