package com.esgi.travel.domain.repository

import com.esgi.travel.domain.model.Travel

interface Travels {
    fun addTravels(travel: Travel)
    fun getAttendees(travelId: String): List<String>
}
