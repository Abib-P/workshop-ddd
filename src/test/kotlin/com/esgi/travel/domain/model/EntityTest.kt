package com.esgi.travel.domain.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class EntityTest {
    @Test
    fun `should an entity be equal to an other entity with same id`() {
        val entity1 = Entity(
            id = GenericID("1"),
        )
        val entity2 = Entity(
            id = GenericID("1"),
        )

        assertEquals(entity1, entity2)
    }
}
