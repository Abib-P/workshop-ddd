package com.esgi.travel.use_cases.travel.housing.dto

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SearchHousingRequestTest {
    @Test
    fun `should convert to address`() {
        val searchHousingRequest = SearchHousingRequest("Paris", "France", 2)

        val address = searchHousingRequest.address()

        assertEquals("Paris", address.city)
        assertEquals("France", address.country)
    }
}
