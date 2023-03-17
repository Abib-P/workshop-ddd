package com.esgi.travel.domain.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import java.time.LocalDate

class ClientTest {
    @Test
    fun `should create a client`() {
        val client = Client(
            id = GenericID.EMPTY,
            firstName = "John",
            lastName = "Doe",
            mail = Mail("email@email.com"),
            birthdate = LocalDate.now().minusYears(20),
        )

        assertEquals("John", client.firstName)
        assertEquals("Doe", client.lastName)
        assertEquals(LocalDate.now().minusYears(20), client.birthdate)
    }

    @Test
    fun `should throw an exception when birth date is in the future`() {
        assertThrows(IllegalArgumentException::class.java) {
            Client(
                id = GenericID.EMPTY,
                firstName = "John",
                lastName = "Doe",
                mail = Mail("email@email.com"),
                birthdate = LocalDate.now().plusYears(1),
            )
        }
    }

    @Test
    fun `should throw an exception when first name is empty`() {
        assertThrows(IllegalArgumentException::class.java) {
            Client(
                id = GenericID.EMPTY,
                firstName = "",
                lastName = "Doe",
                mail = Mail("email@email.com"),
                birthdate = LocalDate.now().minusYears(20),
            )
        }
    }

    @Test
    fun `should throw an exception when last name is empty`() {
        assertThrows(IllegalArgumentException::class.java) {
            Client(
                id = GenericID.EMPTY,
                firstName = "John",
                lastName = "",
                mail = Mail("email@email.com"),
                birthdate = LocalDate.now().minusYears(20),
            )
        }
    }
}

