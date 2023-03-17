package com.esgi.travel.domain.model

class Travel(
    id: GenericID,
    val period: Period,
    val client: Client,
    val destination: Address,
    val attendants: List<Attendant>,
    val budget: Budget,
    val state: TravelState,
    val activitiesIds: Map<Activity, List<GenericID>>,
) : Entity(id) {

    init {

    }

    fun addActivity(activity: Activity, attendants: List<Attendant>){
        activitiesIds.plus(activity.id to attendants.map { it.id })
    }

    fun getAttendantActivities(attendant: Attendant): List<Activity> {
        return activitiesIds.filter { it.value.contains(attendant.id) }.keys.map { it }
    }

}
