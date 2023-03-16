package com.esgi.travel.domain.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class ActivityTest {
    @Test
    fun `should create an activity`() {
        val activity = Activity(
            id = GenericID.EMPTY,
            name = "Activity name",
            description = "Activity description",
            price = 10.0,
            duration = Period(LocalDateTime.of(2020, 1, 1, 0, 0), LocalDateTime.of(2020, 1, 1, 0, 10)),
            restrictions = listOf(),
            address = Address("Address", "City", "Country"),
            capacity = 10
        )

        assertEquals("Activity name", activity.name)
        assertEquals("Activity description", activity.description)
        assertEquals(10.0, activity.price)
        assertEquals(Period(LocalDateTime.of(2020, 1, 1, 0, 0), LocalDateTime.of(2020, 1, 1, 0, 10)), activity.duration)
        assertEquals(emptyList<ActivityRestriction>(), activity.restrictions)
        assertEquals(Address("Address", "City", "Country"), activity.address)
        assertEquals(10, activity.capacity)
    }

}
