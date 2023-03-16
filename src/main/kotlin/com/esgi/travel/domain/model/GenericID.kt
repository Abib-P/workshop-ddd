package com.esgi.travel.domain.model

class GenericID(val value: String) {
    companion object {
        val EMPTY = GenericID("")
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as GenericID

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }
}
