package com.example.studentapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey


    @Entity
    data class Student(
    @PrimaryKey(autoGenerate = true)
    var studentId: Int? = null,
    var email: String,
    var name: String,
    var birthday: String,
    var phone: String,
    var subjects: String?
)