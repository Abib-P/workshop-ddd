package com.esgi.travel.infra.memory

import com.esgi.travel.domain.model.Address
import com.esgi.travel.domain.model.GenericID
import com.esgi.travel.domain.model.Housing
import com.esgi.travel.domain.repository.Housings
import com.esgi.travel.use_cases.travel.housing.dto.SearchHousingRequest

class InMemoryHousings : Housings {
    private val housings = listOf<Housing>(
        Housing(
            id = GenericID("1"),
            address = Address(
                address = "rue de la paix",
                city = "Paris",
                country = "France"
            ),
            maxPerson = 2,
            price = 100.0,
            name = "Airbnb"
        ),
        Housing(
            id = GenericID("2"),
            address = Address(
                address = "12 Queensway",
                city = "Londres",
                country = "Royaume-Uni"
            ),
            maxPerson = 2,
            price = 100.0,
            name = "Airbnb"
        ),
        Housing(
            id = GenericID("3"),
            address = Address(
                address = "1 Carmine Street",
                city = "New York",
                country = "Etats-Unis"
            ),
            maxPerson = 2,
            price = 100.0,
            name = "Airbnb"
        ),
    )

    override fun searchHousings(searchHousingRequest: SearchHousingRequest): List<Housing> {
        return housings
    }
}
