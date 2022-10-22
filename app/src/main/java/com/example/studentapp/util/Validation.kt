package com.example.studentapp.util

import com.example.studentapp.data.entity.Student


sealed class Validation(){
    object Succes: Validation()
    data class  Failed(val message: String): Validation()

}

data class AddStudentFieldsState(

    val name: Validation,
    val surename: Validation,
    val email: Validation,
    val phone: Validation,
    val birthday: Validation,
    val address: Validation,
    val gender: Validation,
    val nationality: Validation,
    val citizenship: Validation

)

