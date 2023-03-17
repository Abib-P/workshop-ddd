package com.esgi.travel.infra.memory

import com.esgi.travel.domain.model.*
import com.esgi.travel.domain.repository.Activities
import com.esgi.travel.use_cases.travel.activity.dto.SearchActivityRequest
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
            Address("1 Avenue Voltaire", "Paris", "France"),
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
            Address("1 Saint John Street", "Londres", "Royaume-Uni"),
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
            Address("1 Carmine Street", "New York", "Etats-Unis"),
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
            Address("Godzilla Road", "Tokyo", "Japon"),
            10
        ),
    )

    //todo faire le filter ici? (ptetre mieux de faire ça dans le service)
    override fun searchActivities(searchActivityRequest: SearchActivityRequest): List<Activity> {
        return activities
            .filter { it.address.city == searchActivityRequest.city && it.address.country == searchActivityRequest.country }
            .filter { it.price <= searchActivityRequest.maxPrice && it.price >= searchActivityRequest.minPrice }
            .filter { it.duration.start.isAfter(searchActivityRequest.startDate) }
            .filter { it.duration.end.isBefore(searchActivityRequest.endDate) }
    }
}
