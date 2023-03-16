package com.esgi.travel.domain.model

open class Entity(val id: GenericID) {
    init {
        if (id.value.isEmpty()) {
            throw IllegalArgumentException("id must not be empty")
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Entity

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}