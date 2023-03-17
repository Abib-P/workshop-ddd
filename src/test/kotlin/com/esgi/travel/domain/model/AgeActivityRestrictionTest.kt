package com.esgi.travel.domain.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.LocalDate

class AgeActivityRestrictionTest {
    @Test
    fun `should create an age restriction`() {
        val restriction = AgeActivityRestriction(18, 25)

        assertEquals(18, restriction.minAge)
        assertEquals(25, restriction.maxAge)
    }

    @Test
    fun `should throw an exception when minAge is greater than maxAge`() {
        assertThrows(IllegalArgumentException::class.java) {
            AgeActivityRestriction(25, 18)
        }
    }

    @Test
    fun `should be satisfied when attendant is older than restriction`() {
        val restriction = AgeActivityRestriction(18, 25)
        val attendant = Attendant(
            GenericID.EMPTY,
            lastName = "John",
            birthdate = LocalDate.now().minusYears(20),
            firstName = "John",
            mail = Mail("email@email.com")
        )

        assertTrue(restriction.isSatisfied(attendant))
    }

    @Test
    fun `should not be satisfied when attendant is younger than restriction`() {
        val restriction = AgeActivityRestriction(18, 25)
        val attendant = Attendant(
            GenericID.EMPTY,
            lastName = "John",
            birthdate = LocalDate.now().minusYears(16),
            firstName = "John",
            mail = Mail("email@email.com")
        )

        assertFalse(restriction.isSatisfied(attendant))
    }

    @Test
    fun `should not be satisfied when attendant is older than restriction`() {
        val restriction = AgeActivityRestriction(18, 25)
        val attendant = Attendant(GenericID.EMPTY,
            lastName = "John",
            birthdate = LocalDate.now().minusYears(29),
            firstName = "John",
            mail = Mail("email@email.com"))

        assertFalse(restriction.isSatisfied(attendant))
    }

}
