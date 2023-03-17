package com.esgi.travel.domain.model

class Housing(
    id: GenericID,
    val name: String,
    val address: Address,
    val maxPerson: Int,
    val price: Double
) : Entity(id) {

    init {
        if (name.isEmpty()) {
            throw IllegalArgumentException("name must not be empty")
        }
        if (maxPerson < 1) {
            throw IllegalArgumentException("nbPersonneMax must be greater than 0")
        }
        if (price < 0) {
            throw IllegalArgumentException("prix must be greater than 0")
        }
    }
}
