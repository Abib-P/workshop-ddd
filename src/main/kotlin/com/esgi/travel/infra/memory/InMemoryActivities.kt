package com.esgi.travel.infra.memory

import com.esgi.travel.domain.model.*
import com.esgi.travel.domain.repository.Activities
import java.time.Duration
import java.time.LocalDateTime
import java.time.Month

class InMemoryActivities : Activities {
    private val activities = listOf<Activity>(
        Activity(
            GenericID("1"),
            "Voyage à Paris",
            "Paris",
            14.99,
            Period(
                LocalDateTime.of(2023, Month.MARCH, 17, 8, 0),
                LocalDateTime.of(2023, Month.MARCH, 17, 8, 0)
                    .plus(Duration.ofDays(3))
            ),
            listOf<ActivityRestriction>(
            ),
            Address( "Paris", "France"),
            10
        ),
        Activity(
            GenericID("2"),
            "Voyage à Londres",
            "Londres",
            14.99,
            Period(
                LocalDateTime.of(2023, Month.MARCH, 17, 8, 0),
                LocalDateTime.of(2023, Month.MARCH, 17, 8, 0)
                    .plus(Duration.ofDays(3))
            ),
            listOf<ActivityRestriction>(
            ),
            Address( "Londres", "Royaume-Uni"),
            10
        ),
        Activity(
            GenericID("3"),
            "Voyage à New York",
            "New York",
            19.99,
            Period(
                LocalDateTime.of(2023, Month.MARCH, 18, 8, 0),
                LocalDateTime.of(2023, Month.MARCH, 18, 8, 0)
                    .plus(Duration.ofDays(3))
            ),
            listOf<ActivityRestriction>(
            ),
            Address("New York", "Etats-Unis"),
            10
        ),
        Activity(
            GenericID("4"),
            "Voyage à Tokyo",
            "Tokyo",
            100.99,
            Period(
                LocalDateTime.of(2023, Month.MARCH, 17, 8, 0),
                LocalDateTime.of(2023, Month.MARCH, 17, 8, 0)
                    .plus(Duration.ofDays(3))
            ),
            listOf<ActivityRestriction>(
                AgeActivityRestriction(18, 99)
            ),
            Address("Tokyo", "Japon"),
            10
        ),
    )

    override fun fetchActivities(): List<Activity> {
        return activities
    }

    override fun getById(activityId: GenericID): Activity? {
        return activities.find { it.id == activityId }
    }
}
