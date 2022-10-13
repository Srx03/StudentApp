package com.example.studentapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey


    @Entity(tableName = "student_table")
    class Student(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var email: String,
    var Name: String,
    var birthday: String,
    var phone: String,
    var subjects: String?
)