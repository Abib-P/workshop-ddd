package com.esgi.travel.use_cases.travel.housing

import com.esgi.travel.domain.model.Address
import com.esgi.travel.domain.model.GenericID
import com.esgi.travel.domain.model.Housing
import com.esgi.travel.domain.repository.Housings
import com.esgi.travel.use_cases.travel.housing.dto.SearchHousingRequest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class SearchHousingTest {
    lateinit var searchHousing: SearchHousing
    lateinit var housings: Housings

    @BeforeEach
    fun setUp() {
        housings = mock()
        searchHousing = SearchHousing(housings)
    }

    @Test
    fun `should return a list of housings`() {
        whenever(housings.fetchHousing()).thenReturn(listOf(
            Housing(
                id = GenericID.EMPTY,
                name = "Housing name",
                price = 10.0,
                maxPerson = 10,
                address = Address("Paris", "France"),
            )
        ))

        val searchHousingRequest = SearchHousingRequest("Paris", "France", 10)
        val result = searchHousing.getAvailableHousings(searchHousingRequest)

        assert(result.isNotEmpty())
    }
}
