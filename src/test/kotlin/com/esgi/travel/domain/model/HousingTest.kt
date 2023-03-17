package com.esgi.travel.domain.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class HousingTest {
    @Test
    fun `should create a housing`() {
        val housing = Housing(
            id = GenericID("1"),
            address = Address("Paris", "France"),
            maxPerson = 3,
            price = 100.0,
            name = "Housing",
        )
        assertEquals(GenericID("1"), housing.id)
        assertEquals(3, housing.maxPerson)
        assertEquals(100.0, housing.price)
    }

    @ParameterizedTest
    @ValueSource(ints = [-3, 0])
    fun `should throw an exception when maxPerson is negative or zero`(maxPerson: Int) {
        assertThrows(IllegalArgumentException::class.java) {
            Housing(
                id = GenericID("1"),
                address = Address("Paris", "France"),
                maxPerson = maxPerson,
                price = 100.0,
                name = "Housing"
            )
        }
    }

    @Test
    fun `should throw an exception when price is negative`() {
        assertThrows(IllegalArgumentException::class.java) {
            Housing(
                id = GenericID("1"),
                address = Address("Paris", "France"),
                maxPerson = 3,
                price = -100.0,
                name = "Housing"
            )
        }
    }

    @Test
    fun `should throw an exception when name is empty`() {
        assertThrows(IllegalArgumentException::class.java) {
            Housing(
                id = GenericID("1"),
                address = Address("Paris", "France"),
                maxPerson = 3,
                price = 100.0,
                name = ""
            )
        }
    }
}
