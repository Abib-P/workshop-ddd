package com.esgi.travel.domain.model

class Travel(
    id: GenericID,
    val period: Period,
    val client: Client,
    val destination: Address,
    val attendants: List<Attendant>,
    val budget: Budget,
    val state: TravelState,
    val activitiesIds: List<GenericID>,
) : Entity(id) {

    init {

    }

    fun addActivity(activity: Activity){
        activitiesIds.plus(activity.id)
    }

}
