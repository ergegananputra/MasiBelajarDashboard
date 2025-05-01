package com.sic6.masibelajar.domain.entities

import kotlinx.serialization.Serializable

@Serializable
data class VideoStreamResponse(
    val frame: String,
    val results: Results
)