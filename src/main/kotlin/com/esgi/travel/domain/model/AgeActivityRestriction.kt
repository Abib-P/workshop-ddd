package com.esgi.travel.domain.model

class AgeActivityRestriction(val minAge: Int, val maxAge: Int) : ActivityRestriction {
    init {
        if (minAge > maxAge) {
            throw IllegalArgumentException("minAge must be lower than maxAge")
        }
    }

    override fun isSatisfied(attendant: Attendant): Boolean {
        val age = attendant.getAge()
        return age in minAge..maxAge
    }
}
