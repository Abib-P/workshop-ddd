package com.esgi.travel.domain.model

import java.time.LocalDateTime

class Periode(val start: LocalDateTime, val end: LocalDateTime) {
    init {
        if (start.isAfter(end)) {
            throw IllegalArgumentException("start must be before end")
        }
    }

}