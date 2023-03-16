package com.esgi.travel.domain.model

class Adresse(val number: Int, val street: String, val city: String, val postalCode: Int, val country: String) {

    init {
        if(number < 0){
            throw IllegalArgumentException("number must be greater than 0")
        }
        if(street.isEmpty()){
            throw IllegalArgumentException("street must not be empty")
        }
        if(city.isEmpty()){
            throw IllegalArgumentException("city must not be empty")
        }
        if(postalCode < 0){
            throw IllegalArgumentException("postalCode must be greater than 0")
        }
        if(country.isEmpty()){
            throw IllegalArgumentException("country must not be empty")
        }
    }

}