package com.esgi.travel.domain.model

import java.time.LocalDate

class Personne(val birthdate: LocalDate, val name: String, val firstName: String, val activites: List<Activite>, val logement: Logement) {

}
