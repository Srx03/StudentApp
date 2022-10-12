package com.example.studentapp.models

data class Student(
    var email: String,
    var id: String,
    var Name: String,
    var birthday: String,
    var phone: String,
    var subjects: List<String>? = null
)