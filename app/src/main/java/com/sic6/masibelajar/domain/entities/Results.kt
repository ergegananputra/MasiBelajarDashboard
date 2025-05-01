package com.sic6.masibelajar.domain.entities

import kotlinx.serialization.Serializable

@Serializable
data class Results(
    val counts: Counts,
    val fall: Boolean,
    val id: String,
    val out_of_safezone: Boolean,
    val timestamp: String
)