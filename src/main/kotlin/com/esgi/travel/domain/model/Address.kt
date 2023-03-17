package com.esgi.travel.domain.model

class Address(val city: String, val country: String) {

    init {
        if (city.isEmpty()) {
            throw IllegalArgumentException("city must not be empty")
        }
        if (country.isEmpty()) {
            throw IllegalArgumentException("country must not be empty")
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Address

        if (city != other.city) return false
        if (country != other.country) return false

        return true
    }

}
