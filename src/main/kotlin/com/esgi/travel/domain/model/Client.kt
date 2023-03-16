package com.esgi.travel.domain.model

import java.time.LocalDate

class Client(id: GenericID, val mail: Mail, val birthdate: LocalDate, val lastName: String, val firstName: String) :Entity(id) {

    init {
        if (birthdate.isAfter(LocalDate.now())) {
            throw IllegalArgumentException("La date de naissance ne peut pas être dans le futur")
        }
        if (lastName.isEmpty()) {
            throw IllegalArgumentException("Le nom ne peut pas être vide")
        }
        if (firstName.isEmpty()) {
            throw IllegalArgumentException("Le prénom ne peut pas être vide")
        }
    }
}
