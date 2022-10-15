package com.example.studentapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "subject_table")
class Subject(
   @PrimaryKey(autoGenerate = true)
   var id: Int? = null,
    var subjectName: String




)