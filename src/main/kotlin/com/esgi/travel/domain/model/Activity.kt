package com.esgi.travel.domain.model

class Activity(id: GenericID,
               val name : String,
               val description : String,
               val price : Double,
               val duration : Int,
               val restriction: List<ActivityRestriction>) : Entity(id) {

    init {
        if (name.isEmpty()) {
            throw IllegalArgumentException("name must not be empty")
        }
        if (description.isEmpty()) {
            throw IllegalArgumentException("description must not be empty")
        }
        if (price < 0) {
            throw IllegalArgumentException("price must be greater than 0")
        }
        if(duration < 0){
            throw IllegalArgumentException("duration must be greater than 0")
        }
    }
}
