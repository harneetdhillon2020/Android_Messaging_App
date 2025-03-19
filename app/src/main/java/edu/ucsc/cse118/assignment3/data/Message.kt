package edu.ucsc.cse118.assignment3.data

import kotlinx.serialization.Serializable

@Serializable
data class Message (
    val id: String,
    var member: String,
    val posted: String,
    val content: String
)