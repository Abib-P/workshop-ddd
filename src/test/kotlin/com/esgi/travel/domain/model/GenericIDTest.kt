package com.esgi.travel.domain.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GenericIDTest {
    @Test
    fun `should create a generic id`() {
        val genericID = GenericID("1")

        assertEquals("1", genericID.value)
    }

    @Test
    fun `should be equal to an other generic id with same value`() {
        val genericID1 = GenericID("1")
        val genericID2 = GenericID("1")

        assertEquals(genericID1, genericID2)
    }
}
