package com.esgi.travel.domain.model

import java.time.LocalDateTime

class Period(val start: LocalDateTime, val end: LocalDateTime) {
    init {
        if (start.isAfter(end)) {
            throw IllegalArgumentException("start must be before end")
        }
    }

    fun overlaps(other: Period): Boolean {
        return start.isBefore(other.end) && end.isAfter(other.start)
    }
}
