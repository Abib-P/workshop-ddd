package com.esgi.travel.domain.model

import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class PeriodTest {
    @Test
    fun `should throw exception when start date is after end date`() {
        assertThrows(IllegalArgumentException::class.java) {
            Period(
                start = LocalDateTime.of(2020, 1, 1, 0, 0),
                end = LocalDateTime.of(2019, 1, 1, 0, 0)
            )
        }
    }
}
