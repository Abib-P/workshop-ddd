package com.esgi.travel.use_cases.travel.activity

import com.esgi.travel.domain.model.Activity
import com.esgi.travel.domain.repository.Activities
import com.esgi.travel.domain.service.ActivityService
import com.esgi.travel.use_cases.travel.activity.dto.SearchActivityRequest

class SearchActivity (private val activities: Activities, private val activityService: ActivityService) {
    fun getAvailableActivities(searchActivityRequest: SearchActivityRequest): List<Activity> {
        val fetchActivitiesResults = activities.fetchActivities()

        return activityService.filterActivity(fetchActivitiesResults, searchActivityRequest)
    }
}
