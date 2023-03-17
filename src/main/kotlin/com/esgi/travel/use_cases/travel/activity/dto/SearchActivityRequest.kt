package com.esgi.travel.use_cases.travel.activity.dto

import java.time.LocalDateTime

data class SearchActivityRequest(
    val minPrice: Double,
    val maxPrice: Double,
    val city: String,
    val country: String,
    val startDate: LocalDateTime,
    val endDate: LocalDateTime
)
