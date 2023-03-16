package com.esgi.travel.domain.model

import java.time.LocalDateTime

class Transport(val type: String, val price: Double, val startTime: LocalDateTime, val arrivedTime: LocalDateTime) {

    init {
        if (startTime.isAfter(arrivedTime)) {
            throw IllegalArgumentException("Start time must be before arrived time")
        }
        if(price < 0) {
            throw IllegalArgumentException("Price must be positive")
        }
        if(type.isEmpty()) {
            throw IllegalArgumentException("Type must not be empty")
        }
    }
}
