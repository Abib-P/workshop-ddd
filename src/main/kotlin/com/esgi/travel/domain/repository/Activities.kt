package com.esgi.travel.domain.repository

import com.esgi.travel.domain.model.Activity
import com.esgi.travel.domain.model.GenericID

interface Activities {
    fun fetchActivities(): List<Activity>
    fun getById(activityId: GenericID): Activity?
}