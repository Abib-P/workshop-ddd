package com.esgi.travel.use_cases.travel.dto

import com.esgi.travel.domain.model.*
import java.time.LocalDateTime

data class TravelInformation(
    val start: LocalDateTime,
    val end: LocalDateTime,
    val country: String,
    val city: String,
    val budgetMin: Double,
    val budgetMax: Double,
    val clientEmail: String,
    val attendants: List<AttendantInformation>
) {
    fun toTravel(client: Client) = Travel(
        period = Period(start = start, end = end),
        activitiesIds = listOf(),
        attendants = attendants.map { it.toAttendant() },
        id = GenericID.EMPTY,
        budget = Budget(min = budgetMin, max = budgetMax),
        client = client,
        destination = Address(city = city, country = country),
        state = TravelState.OPENED
    )
}
