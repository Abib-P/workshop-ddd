package com.esgi.travel.domain.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import java.time.LocalDate

class AttendantTest {

    @Test
    fun `should create an attendant`() {
        val attendant = Attendant(
            id = GenericID.EMPTY,
            firstName = "John",
            lastName = "Doe",
            mail = Mail("email@email.com"),
            birthdate = LocalDate.now().minusYears(20)
        )

        assertEquals("John", attendant.firstName)
        assertEquals("Doe", attendant.lastName)
        assertEquals(LocalDate.now().minusYears(20), attendant.birthdate)
    }

    @Test
    fun `should throw an exception when birth date is in the future`() {
        assertThrows(IllegalArgumentException::class.java) {
            Attendant(
                id = GenericID.EMPTY,
                firstName = "John",
                lastName = "Doe",
                mail = Mail("email@email.com"),
                birthdate = LocalDate.now().plusYears(1)
            )
        }
    }

    @Test
    fun `should throw an exception when first name is empty`() {
        assertThrows(IllegalArgumentException::class.java) {
            Attendant(
                id = GenericID.EMPTY,
                firstName = "",
                lastName = "Doe",
                mail = Mail("email@email.com"),
                birthdate = LocalDate.now().minusYears(20)
            )
        }
    }

    @Test
    fun `should throw an exception when last name is empty`() {
        assertThrows(IllegalArgumentException::class.java) {
            Attendant(
                id = GenericID.EMPTY,
                firstName = "John",
                lastName = "",
                mail = Mail("email@email.com"),
                birthdate = LocalDate.now().minusYears(20)
            )
        }
    }

    @Test
    fun `should get the age of the attendant`() {
        val attendant = Attendant(
            id = GenericID.EMPTY,
            firstName = "John",
            lastName = "Doe",
            mail = Mail("email@email.com"),
            birthdate = LocalDate.now().minusYears(20)
        )

        assertEquals(20, attendant.getAge())
    }

    @Test
    fun `should return be equal when two attendants have the same mail`() {
        val attendant1 = Attendant(
            id = GenericID.EMPTY,
            firstName = "John",
            lastName = "Doe",
            mail = Mail("email@email.com"),
            birthdate = LocalDate.now().minusYears(20),
        )
        val attendant2 = Attendant(
            id = GenericID.EMPTY,
            firstName = "John",
            lastName = "Doe",
            mail = Mail("email@email.com"),
            birthdate = LocalDate.now().minusYears(20),
        )

        assertEquals(attendant1, attendant2)
    }
}
