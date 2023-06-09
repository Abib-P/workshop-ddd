package com.esgi.travel.use_cases.travel.activity

import com.esgi.travel.domain.model.Activity
import com.esgi.travel.domain.model.Address
import com.esgi.travel.domain.model.GenericID
import com.esgi.travel.domain.model.Period
import com.esgi.travel.domain.repository.Activities
import com.esgi.travel.domain.service.ActivityService
import com.esgi.travel.use_cases.travel.activity.dto.SearchActivityRequest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import java.time.LocalDateTime
import java.time.Month


class SearchActivityTest {
    lateinit var searchActivity: SearchActivity
    lateinit var activities: Activities
    lateinit var activityService: ActivityService

    @BeforeEach
    fun setUp() {
        activities = mock()
        activityService = ActivityService()
        searchActivity = SearchActivity(activities, activityService)
    }


    @Test
    fun `should return a list of activities`() {
        whenever(activities.fetchActivities()).thenReturn(listOf(Activity(
            id = GenericID.EMPTY,
            name = "Activity name",
            description = "Activity description",
            price = 10.0,
            duration = Period(
                LocalDateTime.of(2023, 1, 1, 0, 0),
                LocalDateTime.of(2024, 1, 1, 0, 10)
            ),
            restrictions = listOf(),
            address = Address("Paris", "France"),
            capacity = 10
        )))
        val searchActivityRequest = SearchActivityRequest(
            10.0,
            50.0,
            "Paris",
            "France",
            LocalDateTime.of(2022, Month.MARCH, 18, 8, 0),
            LocalDateTime.of(2024, Month.MARCH, 18, 18, 0),
        )
        val activities = searchActivity.getAvailableActivities(searchActivityRequest)
        assert(activities.isNotEmpty())
    }
}
