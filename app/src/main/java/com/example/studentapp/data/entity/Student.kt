package com.example.studentapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


    @Entity
    data class Student(
    @PrimaryKey(autoGenerate = true)
    var studentId: Int = 0,
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