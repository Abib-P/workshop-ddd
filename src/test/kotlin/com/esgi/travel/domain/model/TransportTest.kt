package com.esgi.travel.domain.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.time.LocalDateTime

class TransportTest {
    @Test
    fun `should create a transport`() {
        val transport = Transport(
            id = GenericID.EMPTY,
            type = "Bus",
            price = 10.0,
            departureTime = LocalDateTime.of(2021, 1, 1, 0, 0),
            departureAddress = Address(
                city = "Paris",
                country = "France",
            ),
            arrivedTime = LocalDateTime.of(2021, 1, 2, 0, 0),
            destination = Address(
                city = "Marseille",
                country = "France",
            )
        )

        assertEquals(transport.type, "Bus")
        assertEquals(transport.price, 10.0)
        assertEquals(transport.departureTime, LocalDateTime.of(2021, 1, 1, 0, 0))
        assertEquals(transport.departureAddress, Address(
            city = "Paris",
            country = "France",
        ))
        assertEquals(transport.arrivedTime, LocalDateTime.of(2021, 1, 2, 0, 0))
        assertEquals(transport.destination, Address(
            city = "Marseille",
            country = "France",
        ))
    }

    @Test
    fun `should throw exception when departure address is equal to destination`() {
        val exception = org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
            Transport(
                id = GenericID.EMPTY,
                type = "Bus",
                price = 10.0,
                departureTime = LocalDateTime.now().plusDays(1),
                departureAddress = Address(
                    city = "Paris",
                    country = "France",
                ),
                arrivedTime = LocalDateTime.now().plusDays(2),
                destination = Address(
                    city = "Paris",
                    country = "France",
                )
            )
        }

        assertEquals(exception.message, "Departure and destination must be different")
    }

    @Test
    fun `should throw exception when departure time is after arrived time`() {
        val exception = org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
            Transport(
                id = GenericID.EMPTY,
                type = "Bus",
                price = 10.0,
                departureTime = LocalDateTime.now().plusDays(2),
                departureAddress = Address(
                    city = "Paris",
                    country = "France",
                ),
                arrivedTime = LocalDateTime.now().plusDays(1),
                destination = Address(
                    city = "Marceille",
                    country = "France",
                )
            )
        }

        assertEquals(exception.message, "Start time must be before arrived time")
    }

    @ParameterizedTest
    @ValueSource(doubles = [-10.0, -0.01])
    fun `should throw exception when price is negative`(price: Double) {
        val exception = org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
            Transport(
                id = GenericID.EMPTY,
                type = "Bus",
                price = price,
                departureTime = LocalDateTime.now().plusDays(1),
                departureAddress = Address(
                    city = "Paris",
                    country = "France",
                ),
                arrivedTime = LocalDateTime.now().plusDays(2),
                destination = Address(
                    city = "Marseille",
                    country = "France",
                )
            )
        }

        assertEquals(exception.message, "Price must be positive")
    }

    @Test
    fun `should throw exception when type is empty`() {
        val exception = org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
            Transport(
                id = GenericID.EMPTY,
                type = "",
                price = 10.0,
                departureTime = LocalDateTime.now().plusDays(1),
                departureAddress = Address(
                    city = "Paris",
                    country = "France",
                ),
                arrivedTime = LocalDateTime.now().plusDays(2),
                destination = Address(
                    city = "Marseille",
                    country = "France",
                )
            )
        }

        assertEquals(exception.message, "Type must not be empty")
    }
}
