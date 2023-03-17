package com.esgi.travel.domain.repository

import com.esgi.travel.domain.model.GenericID
import com.esgi.travel.domain.model.Travel

interface Travels {
    fun addTravel(travel: Travel)
    fun getById(id: GenericID): Travel?
    fun save(travel: Travel)
}
