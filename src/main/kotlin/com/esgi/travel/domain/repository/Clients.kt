package com.esgi.travel.domain.repository

import com.esgi.travel.domain.model.Client
import com.esgi.travel.domain.model.GenericID

interface Clients {
    fun add(client: Client)
    fun get(clientId: GenericID): Client?
    fun getByEmail(email: String): Client?
}
