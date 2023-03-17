package com.esgi.travel.use_cases.travel.activity.dto

import com.esgi.travel.domain.model.GenericID

class AddActivityToTravelRequest(val travelId: GenericID, val activityId: GenericID, val attendants: List<GenericID>) {
}