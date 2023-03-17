package com.esgi.travel.domain.model

import java.time.LocalDate

//todo vraiment un id et pas juste l'email pour les différencier ?
class Attendant(id: GenericID, val mail: Mail, val birthdate: LocalDate, val lastName: String, val firstName: String) :
    Entity(id) {

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

    fun getAge(): Int {
        val today = LocalDate.now()
        var age = today.year - birthdate.year
        if (birthdate.monthValue > today.monthValue || (birthdate.monthValue == today.monthValue && birthdate.dayOfMonth > today.dayOfMonth)) {
            age--
        }
        return age
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        if (!super.equals(other)) return false

        other as Attendant

        if (mail != other.mail) return false

        return true
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + mail.hashCode()
        return result
    }

}
