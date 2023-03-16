package com.esgi.travel.domain.model

class Mail(val mail: String){
    init {
        if(mail.isEmpty()){
            throw IllegalArgumentException("Mail must not be empty")
        }
        if(!mail.contains("@")){
            throw IllegalArgumentException("Mail must contain @")
        }
    }
}
