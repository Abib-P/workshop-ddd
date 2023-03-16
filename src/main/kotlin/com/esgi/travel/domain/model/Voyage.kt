package com.esgi.travel.domain.model

class Voyage(
    id: GenericID,
    val client: Client,
    val destination: Address,
    val Attendants: List<Attendant>,
    val budget: Budget,
) : Entity(id) {

    init {

    }

}