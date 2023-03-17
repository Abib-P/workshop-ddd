package com.esgi.travel.use_cases.travel.dto

import com.esgi.travel.domain.model.Attendant
import com.esgi.travel.domain.model.GenericID
import com.esgi.travel.domain.model.Mail
import java.time.LocalDate

data class AttendantInformation(
    val mail: String,
    val birthDate: LocalDate,
    val firstName: String,
    val lastName: String
) {
    fun toAttendant() = Attendant(
        mail = Mail(mail),
        birthdate = birthDate,
        firstName = firstName,
        lastName = lastName,
        id = GenericID.EMPTY
    )
}
