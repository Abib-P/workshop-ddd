package com.esgi.travel.domain.model

class AgeActiviteRestriction(val minAge: Int, val maxAge: Int) : ActivityRestriction {
    init {
        if (minAge > maxAge) {
            throw IllegalArgumentException("minAge must be lower than maxAge")
        }
    }

    override fun isSatisfied(): Boolean {
        TODO("Not yet implemented")
    }
}
