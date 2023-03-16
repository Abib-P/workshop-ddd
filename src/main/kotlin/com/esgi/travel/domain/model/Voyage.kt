package com.esgi.travel.domain.model

class Voyage(
    id: GenericID,
    val client: Client,
    val destination: Adresse,
    val Attendants: List<Attendant>,
    val budget: Budget,
) : Entity(id) {

    init {

    }

}