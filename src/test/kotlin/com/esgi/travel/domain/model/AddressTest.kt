package com.esgi.travel.domain.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class AddressTest {
    @Test
    fun `should create an address`() {
        val address = Address("Paris", "France")

        assertEquals("Paris", address.city)
        assertEquals("France", address.country)
    }

    @Test
    fun `should be equal`() {
        val address1 = Address( "Paris", "France")
        val address2 = Address( "Paris", "France")

        assertEquals(address1, address2)
    }

    @Test
    fun `should throw an exception when city is empty`() {
        assertThrows(IllegalArgumentException::class.java) {
            Address("", "France")
        }
    }

    @Test
    fun `should throw an exception when country is empty`() {
        assertThrows(IllegalArgumentException::class.java) {
            Address("Paris", "")
        }
    }
}
