package com.esgi.travel.use_cases.travel.housing.dto

import com.esgi.travel.domain.model.Address
import java.time.LocalDateTime


data class SearchHousingRequest (
    val city: String,
    val country: String,
    val nbPerson: Int
) {
    fun address(): Address {
        return Address(city, country)
    }
}
