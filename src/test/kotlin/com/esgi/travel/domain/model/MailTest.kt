package com.esgi.travel.domain.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MailTest {
    @Test
    fun `should throw exception when mail is empty`() {
        assertThrows(IllegalArgumentException::class.java) {
            Mail("")
        }
    }

    @Test
    fun `should throw exception when mail does not contain @`() {
        assertThrows(IllegalArgumentException::class.java) {
            Mail("mail")
        }
    }
}
