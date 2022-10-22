package com.example.studentapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Subject(
   @PrimaryKey(autoGenerate = true)
   var subjectId: Int = 0,
   var subjectName: String


)