package com.esgi.travel.domain.model

class Address(val address: String, val city: String, val country: String) {

    init {
        if (city.isEmpty()) {
            throw IllegalArgumentException("city must not be empty")
        }
        if (country.isEmpty()) {
            throw IllegalArgumentException("country must not be empty")
        }
    }

}