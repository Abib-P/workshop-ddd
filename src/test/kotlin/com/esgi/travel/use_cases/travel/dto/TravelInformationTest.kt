package com.esgi.travel.use_cases.travel.dto

import com.esgi.travel.domain.model.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDateTime


class TravelInformationTest {
    @Test
    fun `should convert to Travel`() {
        val travelInformation = TravelInformation(
            start = LocalDateTime.of(2020, 1, 1, 0, 0),
            end = LocalDateTime.of(2020, 1, 2, 0, 0),
            country = "country",
            city = "city",
            budgetMin = 0.0,
            budgetMax = 100.0,
            clientEmail = "email@email.com",
            attendants = listOf(),
        )

        val client =  Client(
            mail = Mail("email@email.com"),
            birthdate = LocalDateTime.of(2020, 1, 1, 0, 0).toLocalDate(),
            firstName = "firstName",
            lastName = "lastName",
            id = GenericID.EMPTY
        )

        val travel = travelInformation.toTravel(client = client)

        val expectedTravel = Travel(
            period = Period(start = LocalDateTime.of(2020, 1, 1, 0, 0), end = LocalDateTime.of(2020, 1, 2, 0, 0)),
            activitiesIds = mapOf(),
            attendants = listOf(),
            id = GenericID.EMPTY,
            budget = Budget(min = 0.0, max = 100.0),
            client = client,
            destination = Address(city = "city", country = "country"),
            state = TravelState.OPENED
        )

        assertEquals(expectedTravel, travel)
    }
}
