package com.esgi.travel.use_cases.travel

import com.esgi.travel.domain.repository.Activities
import com.esgi.travel.domain.repository.Travels
import com.esgi.travel.use_cases.travel.activity.dto.AddActivityToTravelRequest

class AddActivityToTravel(val travels: Travels, val activities: Activities) {
    fun addActivityToTravel(addActivityToTravelRequest: AddActivityToTravelRequest) {
        val travel = travels.getById(addActivityToTravelRequest.travelId) ?: throw Exception("Travel not found")
        val activity = activities.getById(addActivityToTravelRequest.activityId) ?: throw Exception("Activity not found")
        val attendants = addActivityToTravelRequest.attendants.map { attendantId ->
            travel.attendants.find { attendant -> attendant.id == attendantId } ?: throw Exception("Attendant not found")
        }

        if(activity.capacity < attendants.size) {
            throw Exception("Activity is full")
        }

        for (attendant in attendants) {
            if(!activity.canParticipate(attendant)) {
                throw Exception("Attendant can't participate to this activity")
            }
        }

        travel.addActivity(activity)
        travels.save(travel)
    }
}
