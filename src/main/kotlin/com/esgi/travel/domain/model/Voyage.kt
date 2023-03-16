package com.esgi.travel.domain.model

import javax.print.attribute.standard.Destination

class Voyage(
    id: GenericID,
    val client : Client,
    val destination: Adresse,
    val Attendants: List<Attendant>,
    val budget: Budget,
) : Entity(id) {

    init {

    }

}