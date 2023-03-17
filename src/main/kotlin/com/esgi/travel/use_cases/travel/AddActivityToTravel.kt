package com.esgi.travel.use_cases.travel

import com.esgi.travel.domain.repository.Activities
import com.esgi.travel.domain.repository.Travels
import com.esgi.travel.domain.service.ActivityService
import com.esgi.travel.use_cases.travel.activity.dto.AddActivityToTravelRequest

class AddActivityToTravel(
    private val travels: Travels,
    private val activities: Activities,
    private val activityService: ActivityService
) {
    fun addActivityToTravel(addActivityToTravelRequest: AddActivityToTravelRequest) {
        val travel = travels.getById(addActivityToTravelRequest.travelId) ?: throw Exception("Travel not found")
        val activity = activities.getById(addActivityToTravelRequest.activityId) ?: throw Exception("Activity not found")
        val attendants = addActivityToTravelRequest.attendants.map { attendantId ->
            travel.attendants.find { attendant -> attendant.id == attendantId } ?: throw Exception("Attendant not found")
        }

        activityService.canAddToTravel(activity, attendants)

        travel.addActivity(activity, attendants)
        travels.save(travel)
    }
}
