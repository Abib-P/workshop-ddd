package com.esgi.travel.domain.repository

import com.esgi.travel.domain.model.Travel

interface Travels {
    fun addTravel(travel: Travel)
}
