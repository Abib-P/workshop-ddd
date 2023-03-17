package com.esgi.travel.domain.model

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.LocalDate
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
            address = Address("City", "Country"),
            capacity = 10
        )

        assertEquals("Activity name", activity.name)
        assertEquals("Activity description", activity.description)
        assertEquals(10.0, activity.price)
        assertEquals(emptyList<ActivityRestriction>(), activity.restrictions)
        assertEquals(10, activity.capacity)
    }

    @Test
    fun `should throw an exception when name is empty`() {
        assertThrows(IllegalArgumentException::class.java) {
            Activity(
                id = GenericID.EMPTY,
                name = "",
                description = "Activity description",
                price = 10.0,
                duration = Period(LocalDateTime.of(2020, 1, 1, 0, 0), LocalDateTime.of(2020, 1, 1, 0, 10)),
                restrictions = listOf(),
                address = Address("City", "Country"),
                capacity = 10
            )
        }
    }

    @Test
    fun `should throw an exception when description is empty`() {
        assertThrows(IllegalArgumentException::class.java) {
            Activity(
                id = GenericID.EMPTY,
                name = "Activity name",
                description = "",
                price = 10.0,
                duration = Period(LocalDateTime.of(2020, 1, 1, 0, 0), LocalDateTime.of(2020, 1, 1, 0, 10)),
                restrictions = listOf(),
                address = Address("City", "Country"),
                capacity = 10
            )
        }
    }

    @Test
    fun `should throw an exception when price is negative`() {
        assertThrows(IllegalArgumentException::class.java) {
            Activity(
                id = GenericID.EMPTY,
                name = "Activity name",
                description = "Activity description",
                price = -10.0,
                duration = Period(LocalDateTime.of(2020, 1, 1, 0, 0), LocalDateTime.of(2020, 1, 1, 0, 10)),
                restrictions = listOf(),
                address = Address("City", "Country"),
                capacity = 10
            )
        }
    }

    @Test
    fun `should allow to participate`() {
        val attendant = Attendant(GenericID.EMPTY,
            Mail("mail@mail"),
            LocalDate.now().minusYears(18),
            "patate",
            "patate")

        val activity = Activity(
            id = GenericID.EMPTY,
            name = "Activity name",
            description = "Activity description",
            price = 10.0,
            duration = Period(LocalDateTime.of(2020, 1, 1, 0, 0), LocalDateTime.of(2020, 1, 1, 0, 10)),
            restrictions = listOf(AgeActivityRestriction(18,9999)),
            address = Address("City", "Country"),
            capacity = 10
        )

        assertTrue(activity.canParticipate(attendant))
    }

    @Test
    fun `should not allow to participate when age restriction not satisfied`() {
        val attendant = Attendant(GenericID.EMPTY,
            Mail("mail@mail"),
            LocalDate.now().minusYears(17),
            "patate",
            "patate")

        val activity = Activity(
            id = GenericID.EMPTY,
            name = "Activity name",
            description = "Activity description",
            price = 10.0,
            duration = Period(LocalDateTime.of(2020, 1, 1, 0, 0), LocalDateTime.of(2020, 1, 1, 0, 10)),
            restrictions = listOf(AgeActivityRestriction(18,9999)),
            address = Address("City", "Country"),
            capacity = 10
        )

        assertFalse(activity.canParticipate(attendant))
    }
}
