package com.esgi.travel.use_cases.travel.activity

import com.esgi.travel.domain.model.Activity
import com.esgi.travel.domain.repository.Activities
import com.esgi.travel.use_cases.travel.activity.dto.SearchActivityRequest

class SearchActivity (private val activities: Activities) {
    fun getAvailableActivities(searchActivityRequest: SearchActivityRequest): List<Activity> {
        return activities.searchActivities(searchActivityRequest)
    }
}
