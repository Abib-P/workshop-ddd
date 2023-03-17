package com.esgi.travel.use_cases.travel.dto

import com.esgi.travel.domain.model.Attendant
import com.esgi.travel.domain.model.GenericID

data class AddActivityToTravel(val travelId: GenericID, val activityId: GenericID, val attendants: List<Attendant>)
