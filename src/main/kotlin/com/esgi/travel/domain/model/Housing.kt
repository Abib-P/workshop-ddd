package com.esgi.travel.domain.model

class Housing(val address: Adresse, val maxPerson : Int, val price : Double) {

    init {
        if(maxPerson < 1){
            throw IllegalArgumentException("nbPersonneMax must be greater than 0")
        }
        if(price < 0){
            throw IllegalArgumentException("prix must be greater than 0")
        }
    }
}
