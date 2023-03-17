package com.esgi.travel.domain.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class AddressTest {
    @Test
    fun `should create an address`() {
        val address = Address("1 rue de la paix", "Paris", "France")

        assertEquals("1 rue de la paix", address.address)
        assertEquals("Paris", address.city)
        assertEquals("France", address.country)
    }

    @Test
    fun `should be equal`() {
        val address1 = Address("1 rue de la paix", "Paris", "France")
        val address2 = Address("1 rue de la paix", "Paris", "France")

        assertEquals(address1, address2)
    }

    @Test
    fun `should throw an exception when city is empty`() {
        assertThrows(IllegalArgumentException::class.java) {
            Address("1 rue de la paix", "", "France")
        }
    }

    @Test
    fun `should throw an exception when country is empty`() {
        assertThrows(IllegalArgumentException::class.java) {
            Address("1 rue de la paix", "Paris", "")
        }
    }
}
