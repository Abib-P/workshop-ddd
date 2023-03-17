package com.esgi.travel.domain.model

class Activity(
    id: GenericID,
    val name: String,
    val description: String,
    val price: Double,
    val duration: Period,
    val restrictions: List<ActivityRestriction>,
    val address: Address,
    val capacity: Int,
) : Entity(id) {

    init {
        if (name.isEmpty()) {
            throw IllegalArgumentException("name must not be empty")
        }
        if (description.isEmpty()) {
            throw IllegalArgumentException("description must not be empty")
        }
        if (price < 0) {
            throw IllegalArgumentException("price must be greater than 0")
        }
    }

    fun canParticipate(attendant: Attendant): Boolean {
        return restrictions.all { it.isSatisfied(attendant) }
    }
}
