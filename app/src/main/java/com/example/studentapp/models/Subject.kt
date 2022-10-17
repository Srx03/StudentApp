package com.example.studentapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity
data class Subject(
   @PrimaryKey(autoGenerate = true)
   var subjectId: Int = 0,
    var subjectName: String


)