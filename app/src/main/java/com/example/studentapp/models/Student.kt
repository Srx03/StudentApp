package com.example.studentapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey


    @Entity
    data class Student(
    @PrimaryKey(autoGenerate = true)
    var studentId: Int? = null,
    var name: String,
    var surename: String,
    var email: String,
    var birthday: String,
    var phone: String,
    var address: String,
    var gender: String,
    var nationality: String,
    var citizenship: String
)