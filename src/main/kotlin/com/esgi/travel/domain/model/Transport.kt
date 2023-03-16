package com.esgi.travel.domain.model

import java.time.LocalDateTime

class Transport(val type: String, val price: Double, val departureTime: LocalDateTime, val departureAdresse: Adresse, val arrivedTime: LocalDateTime, val destination: Adresse) {

    init {
        if (departureAdresse == destination) {
            throw IllegalArgumentException("Departure and destination must be different")
        }
        if (departureTime.isAfter(arrivedTime)) {
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
