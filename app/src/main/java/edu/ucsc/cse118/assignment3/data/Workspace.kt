package edu.ucsc.cse118.assignment3.data

import kotlinx.serialization.Serializable

@Serializable
data class Workspace (
    val id: String,
    val name: String,
    val owner: String,
    val channels: Int,
)
