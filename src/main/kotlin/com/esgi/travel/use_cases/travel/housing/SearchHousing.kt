package com.esgi.travel.use_cases.travel.housing

import com.esgi.travel.domain.model.Housing
import com.esgi.travel.domain.repository.Housings
import com.esgi.travel.use_cases.travel.housing.dto.SearchHousingRequest
import java.lang.Exception

class SearchHousing (private val housings: Housings) {
    fun getAvailableHousings(searchHousingRequest: SearchHousingRequest): List<Housing> {
        val fetchHousingsResult = housings.fetchHousing() ?: throw Exception("Housings not found")

        return fetchHousingsResult
            .filter { it.address == searchHousingRequest.address() }
            .filter { it.maxPerson >= searchHousingRequest.nbPerson }
    }
}
