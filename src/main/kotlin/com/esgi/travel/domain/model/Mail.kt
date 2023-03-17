package com.esgi.travel.domain.model

class Mail(val mail: String) {
    init {
        if (mail.isEmpty()) {
            throw IllegalArgumentException("Mail must not be empty")
        }
        if (!mail.contains("@")) {
            throw IllegalArgumentException("Mail must contain @")
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Mail

        if (mail != other.mail) return false

        return true
    }

    override fun hashCode(): Int {
        return mail.hashCode()
    }
}
