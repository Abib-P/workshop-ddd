package com.esgi.travel.domain.repository

import com.esgi.travel.domain.model.Housing
import com.esgi.travel.use_cases.travel.housing.dto.SearchHousingRequest

interface Housings {
    fun searchHousings(searchHousingRequest: SearchHousingRequest): List<Housing>
}
