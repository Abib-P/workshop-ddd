package com.esgi.travel.use_cases.travel

import com.esgi.travel.domain.repository.Clients
import com.esgi.travel.domain.repository.Travels
import com.esgi.travel.use_cases.travel.dto.TravelInformation

class OrganiseTravel(val travels: Travels, val clients: Clients) {
    fun createTravel(travelInformation: TravelInformation) {

        val client = clients.getByEmail(travelInformation.clientEmail) ?: throw Exception("Client not found")

        val travel = travelInformation.toTravel(client)

        travels.addTravel(travel)
    }
}
