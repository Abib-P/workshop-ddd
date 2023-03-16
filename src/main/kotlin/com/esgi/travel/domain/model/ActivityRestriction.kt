package com.esgi.travel.domain.model

interface ActivityRestriction {
    fun isSatisfied(attendant: Attendant): Boolean
}
