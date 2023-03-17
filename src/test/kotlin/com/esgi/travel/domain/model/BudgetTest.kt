package com.esgi.travel.domain.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.math.min

class BudgetTest {
    @Test
    fun `should create a budget`() {
        val budget = Budget(
            min = 100.0,
            max = 1000.0
        )
        assertEquals(100.0, budget.min)
        assertEquals(1000.0, budget.max)
    }

    @Test
    fun `should throw an exception when min is negative`() {
        assertThrows(IllegalArgumentException::class.java) {
            Budget(
                min = -100.0,
                max = 1000.0
            )
        }
    }

    @Test
    fun `should throw an exception when max is negative`() {
        assertThrows(IllegalArgumentException::class.java) {
            Budget(
                min = 100.0,
                max = -1000.0
            )
        }
    }

    @Test
    fun `should throw an exception when min is greater than max`() {
        assertThrows(IllegalArgumentException::class.java) {
            Budget(
                min = 1000.0,
                max = 100.0
            )
        }
    }
}
