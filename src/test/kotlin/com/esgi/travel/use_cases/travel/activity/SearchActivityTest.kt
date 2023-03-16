package com.esgi.travel.use_cases.travel.activity

import com.esgi.travel.domain.repository.Activities
import com.esgi.travel.infra.memory.InMemoryActivities
import com.esgi.travel.use_cases.travel.activity.dto.SearchActivityRequest
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import java.time.Month

class SearchActivityTest {
    private lateinit var searchActivity : SearchActivity

    init {
        val activities : Activities = InMemoryActivities()
        searchActivity = SearchActivity(activities)
    }

    @Test
    fun `should return a list of activities`() {
        val searchActivityRequest = SearchActivityRequest(
            10.0,
            50.0,
            "Paris",
            "France",
            LocalDateTime.of(2023, Month.MARCH, 18, 8, 0),
            LocalDateTime.of(2023, Month.MARCH, 18, 18, 0),
        )
        val activities = searchActivity.getAvailableActivities(searchActivityRequest)
        assert(activities.isNotEmpty())
    }
}