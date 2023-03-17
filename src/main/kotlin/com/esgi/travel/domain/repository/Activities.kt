package com.esgi.travel.domain.repository

import com.esgi.travel.domain.model.Activity
import com.esgi.travel.domain.model.GenericID
import com.esgi.travel.use_cases.travel.activity.dto.SearchActivityRequest

interface Activities {
    fun searchActivities(searchActivityRequest: SearchActivityRequest): List<Activity>
    fun getById(activityId: GenericID): Activity?
}