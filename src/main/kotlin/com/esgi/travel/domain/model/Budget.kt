package com.esgi.travel.domain.model

class Budget(val min:Double, val max: Double) {
    init {
        if(min < 0){
            throw IllegalArgumentException("min must be greater than 0")
        }
        if(max < 0){
            throw IllegalArgumentException("max must be greater than 0")
        }
        if(min > max){
            throw IllegalArgumentException("min must be lower than max")
        }
    }
}
