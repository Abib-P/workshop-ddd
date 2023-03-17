package com.esgi.travel.use_cases.travel.dto

import com.esgi.travel.domain.model.Attendant
import com.esgi.travel.domain.model.GenericID
import com.esgi.travel.domain.model.Mail
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.LocalDate

class AttendantInformationTest {
    @Test
    fun `should be converted to Attendee`() {
        val attendantInformation = AttendantInformation(
            mail = "mail@mail.com",
            birthDate = LocalDate.of(2020, 1, 1),
            firstName = "firstName",
            lastName = "lastName",
        )

        val attendant = attendantInformation.toAttendant()

        val expectedAttendant = Attendant(
            mail = Mail("mail@mail.com"),
            birthdate = LocalDate.of(2020, 1, 1),
            firstName = "firstName",
            lastName = "lastName",
            id = GenericID.EMPTY
        )

        assertEquals(expectedAttendant, attendant)

    }
}
