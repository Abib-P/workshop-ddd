package com.esgi.travel.use_cases.travel

import com.esgi.travel.domain.model.*
import com.esgi.travel.domain.repository.Activities
import com.esgi.travel.domain.repository.Travels
import com.esgi.travel.use_cases.travel.activity.dto.AddActivityToTravelRequest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import java.time.LocalDate
import java.time.LocalDateTime

class AddActivityToTravelTest {

    lateinit var addActivity: AddActivityToTravel
    lateinit var activities: Activities
    lateinit var travels: Travels

    @BeforeEach
    fun setUp() {
        activities = mock()
        travels = mock()
        addActivity = AddActivityToTravel(travels, activities)
    }

    @Test
    fun `should add activity to travel` () {

        whenever(activities.getById(any())).thenReturn(Activity(
            id = GenericID.EMPTY,
            name = "Activity name",
            description = "Activity description",
            price = 10.0,
            duration = Period(LocalDateTime.of(2020, 1, 1, 0, 0), LocalDateTime.of(2020, 1, 1, 0, 10)),
            restrictions = listOf(),
            address = Address("City", "Country"),
            capacity = 10
        ))

        whenever(travels.getById(any())).thenReturn(
            Travel(
                id = GenericID.EMPTY,
                period = Period(LocalDateTime.of(2020, 1, 1, 0, 0), LocalDateTime.of(2020, 1, 1, 0, 10)),
                  client = Client(
                        GenericID.EMPTY,
                        Mail("mail@mail"),
                        LocalDate.now().minusYears(18),
                        "patate",
                        "patate"),
                destination = Address("City", "Country"),
                attendants = listOf(
                    Attendant(
                        GenericID("1"),
                        Mail("mail@mail"),
                        LocalDate.now().minusYears(18),
                        "patate",
                        "patate"),
                    Attendant(
                        GenericID("2"),
                        Mail("mail2@mail"),
                        LocalDate.now().minusYears(18),
                        "patate2",
                        "patate2")
                ),
                budget = Budget(0.0, 100.0),
                state = TravelState.OPENED,
                activitiesIds = listOf()
        ))

        assertDoesNotThrow { addActivity.addActivityToTravel(AddActivityToTravelRequest(GenericID.EMPTY, GenericID.EMPTY, listOf(GenericID("1"), GenericID("2")))) }
    }

    @Test
    fun `should not add activity to travel when attendant does not satisfied activity age restriction` () {

        whenever(activities.getById(any())).thenReturn(Activity(
            id = GenericID.EMPTY,
            name = "Activity name",
            description = "Activity description",
            price = 10.0,
            duration = Period(LocalDateTime.of(2020, 1, 1, 0, 0), LocalDateTime.of(2020, 1, 1, 0, 10)),
            restrictions = listOf(AgeActivityRestriction(18, 100)),
            address = Address("City", "Country"),
            capacity = 10
        ))

        whenever(travels.getById(any())).thenReturn(
            Travel(
                id = GenericID.EMPTY,
                period = Period(LocalDateTime.of(2020, 1, 1, 0, 0), LocalDateTime.of(2020, 1, 1, 0, 10)),
                client = Client(
                    GenericID.EMPTY,
                    Mail("mail@mail"),
                    LocalDate.now().minusYears(18),
                    "patate",
                    "patate"),
                destination = Address("City", "Country"),
                attendants = listOf(
                    Attendant(
                        GenericID("1"),
                        Mail("mail@mail"),
                        LocalDate.now().minusYears(17),
                        "patate",
                        "patate"),
                    Attendant(
                        GenericID("2"),
                        Mail("mail2@mail"),
                        LocalDate.now().minusYears(18),
                        "patate2",
                        "patate2")
                ),
                budget = Budget(0.0, 100.0),
                state = TravelState.OPENED,
                activitiesIds = listOf()
            ))

        assertThrows<Exception> { addActivity.addActivityToTravel(AddActivityToTravelRequest(GenericID.EMPTY, GenericID.EMPTY, listOf(GenericID("1"), GenericID("2")))) }
    }

    @Test
    fun `should not add activity to travel when activity is full` () {
        whenever(activities.getById(any())).thenReturn(Activity(
            id = GenericID.EMPTY,
            name = "Activity name",
            description = "Activity description",
            price = 10.0,
            duration = Period(LocalDateTime.of(2020, 1, 1, 0, 0), LocalDateTime.of(2020, 1, 1, 0, 10)),
            restrictions = listOf(AgeActivityRestriction(18, 100)),
            address = Address("City", "Country"),
            capacity = 1
        ))

        whenever(travels.getById(any())).thenReturn(
            Travel(
                id = GenericID.EMPTY,
                period = Period(LocalDateTime.of(2020, 1, 1, 0, 0), LocalDateTime.of(2020, 1, 1, 0, 10)),
                client = Client(
                    GenericID.EMPTY,
                    Mail("mail@mail"),
                    LocalDate.now().minusYears(18),
                    "patate",
                    "patate"),
                destination = Address("City", "Country"),
                attendants = listOf(
                    Attendant(
                        GenericID("1"),
                        Mail("mail@mail"),
                        LocalDate.now().minusYears(17),
                        "patate",
                        "patate"),
                    Attendant(
                        GenericID("2"),
                        Mail("mail2@mail"),
                        LocalDate.now().minusYears(18),
                        "patate2",
                        "patate2")
                ),
                budget = Budget(0.0, 100.0),
                state = TravelState.OPENED,
                activitiesIds = listOf()
            ))

        assertThrows<Exception> { addActivity.addActivityToTravel(AddActivityToTravelRequest(GenericID.EMPTY, GenericID.EMPTY, listOf(GenericID("1"), GenericID("2")))) }
    }

    @Test
    fun `should not add activity to travel when activity does not exist` () {
        whenever(activities.getById(any())).thenReturn(Activity(
            id = GenericID.EMPTY,
            name = "Activity name",
            description = "Activity description",
            price = 10.0,
            duration = Period(LocalDateTime.of(2020, 1, 1, 0, 0), LocalDateTime.of(2020, 1, 1, 0, 10)),
            restrictions = listOf(AgeActivityRestriction(18, 100)),
            address = Address("City", "Country"),
            capacity = 1
        ))

        whenever(travels.getById(any())).thenReturn(
            Travel(
                id = GenericID.EMPTY,
                period = Period(LocalDateTime.of(2020, 1, 1, 0, 0), LocalDateTime.of(2020, 1, 1, 0, 10)),
                client = Client(
                    GenericID.EMPTY,
                    Mail("mail@mail"),
                    LocalDate.now().minusYears(18),
                    "patate",
                    "patate"),
                destination = Address("City", "Country"),
                attendants = listOf(
                    Attendant(
                        GenericID("1"),
                        Mail("mail@mail"),
                        LocalDate.now().minusYears(17),
                        "patate",
                        "patate"),
                    Attendant(
                        GenericID("2"),
                        Mail("mail2@mail"),
                        LocalDate.now().minusYears(18),
                        "patate2",
                        "patate2")
                ),
                budget = Budget(0.0, 100.0),
                state = TravelState.OPENED,
                activitiesIds = listOf()
            ))

        assertThrows<Exception> { addActivity.addActivityToTravel(AddActivityToTravelRequest(GenericID.EMPTY, GenericID.EMPTY, listOf(GenericID("1"), GenericID("2")))) }
    }

    @Test
    fun `should not add activity to travel when travel does not exist` () {
        whenever(activities.getById(any())).thenReturn(Activity(
            id = GenericID.EMPTY,
            name = "Activity name",
            description = "Activity description",
            price = 10.0,
            duration = Period(LocalDateTime.of(2020, 1, 1, 0, 0), LocalDateTime.of(2020, 1, 1, 0, 10)),
            restrictions = listOf(AgeActivityRestriction(18, 100)),
            address = Address("City", "Country"),
            capacity = 1
        ))

        whenever(travels.getById(any())).thenReturn(null)

        assertThrows<Exception> { addActivity.addActivityToTravel(AddActivityToTravelRequest(GenericID.EMPTY, GenericID.EMPTY, listOf(GenericID("1"), GenericID("2")))) }
    }

    @Test
    fun `should not add activity to travel when attendant does not exist` () {
        whenever(activities.getById(any())).thenReturn(Activity(
            id = GenericID.EMPTY,
            name = "Activity name",
            description = "Activity description",
            price = 10.0,
            duration = Period(LocalDateTime.of(2020, 1, 1, 0, 0), LocalDateTime.of(2020, 1, 1, 0, 10)),
            restrictions = listOf(),
            address = Address("City", "Country"),
            capacity = 10
        ))

        whenever(travels.getById(any())).thenReturn(
            Travel(
                id = GenericID.EMPTY,
                period = Period(LocalDateTime.of(2020, 1, 1, 0, 0), LocalDateTime.of(2020, 1, 1, 0, 10)),
                client = Client(
                    GenericID.EMPTY,
                    Mail("mail@mail"),
                    LocalDate.now().minusYears(18),
                    "patate",
                    "patate"),
                destination = Address("City", "Country"),
                attendants = listOf(
                    Attendant(
                        GenericID("1"),
                        Mail("mail@mail"),
                        LocalDate.now().minusYears(17),
                        "patate",
                        "patate")
                ),
                budget = Budget(0.0, 100.0),
                state = TravelState.OPENED,
                activitiesIds = listOf()
            ))

        assertThrows<Exception> { addActivity.addActivityToTravel(AddActivityToTravelRequest(GenericID.EMPTY, GenericID.EMPTY, listOf(GenericID("1"), GenericID("2")))) }
    }

}