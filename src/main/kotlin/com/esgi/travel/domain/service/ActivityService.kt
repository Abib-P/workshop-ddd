package com.esgi.travel.domain.service

import com.esgi.travel.domain.model.Activity
import com.esgi.travel.domain.model.Attendant
import com.esgi.travel.domain.model.Travel
import com.esgi.travel.use_cases.travel.activity.dto.SearchActivityRequest

class ActivityService {
    fun filterActivity(activities: List<Activity>, searchActivityRequest: SearchActivityRequest): List<Activity> {
        return activities
            .filter { it.address.city == searchActivityRequest.city && it.address.country == searchActivityRequest.country }
            .filter { it.price <= searchActivityRequest.maxPrice && it.price >= searchActivityRequest.minPrice }
            .filter { it.duration.start.isAfter(searchActivityRequest.startDate) }
            .filter { it.duration.end.isBefore(searchActivityRequest.endDate) }
    }

    fun checkCanAddToTravel(travel: Travel, activity: Activity, attendants: List<Attendant>) {
        if(!travel.period.contains(activity.duration)) {
            throw Exception("Activity is not in travel period")
        }

        if(activity.capacity < attendants.size) {
            throw Exception("Activity is full")
        }

        for (attendant in attendants) {
            if(!activity.canParticipate(attendant)) {
                throw Exception("Attendant can't participate to this activity")
            }

            val attendantActivities = travel.getAttendantActivities(attendant)
            for (attendantActivity in attendantActivities) {
                if(attendantActivity.duration.overlaps(activity.duration)) {
                    throw Exception("Attendant already has an activity at this time")
                }
            }

        }
    }

}