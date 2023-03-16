package com.esgi.travel.domain.model

class Activite(val name : String, val description : String, val price : Double, val duration : Int, val restriction: List<ActiviteRestriction>) {
}
