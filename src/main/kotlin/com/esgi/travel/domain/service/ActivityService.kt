package com.esgi.travel.domain.service

import com.esgi.travel.domain.model.Activity
import com.esgi.travel.use_cases.travel.activity.dto.SearchActivityRequest

class ActivityService {
    fun filterActivity(activities: List<Activity>, searchActivityRequest: SearchActivityRequest): List<Activity> {
        return activities
            .filter { it.address.city == searchActivityRequest.city && it.address.country == searchActivityRequest.country }
            .filter { it.price <= searchActivityRequest.maxPrice && it.price >= searchActivityRequest.minPrice }
            .filter { it.duration.start.isAfter(searchActivityRequest.startDate) }
            .filter { it.duration.end.isBefore(searchActivityRequest.endDate) }
    }

}