package com.esgi.travel.domain.model

class Travel(
    id: GenericID,
    val client: Client,
    val destination: Address,
    val Attendants: List<Attendant>,
    val budget: Budget,
    val state: TravelState,
) : Entity(id) {

    init {

    }

}