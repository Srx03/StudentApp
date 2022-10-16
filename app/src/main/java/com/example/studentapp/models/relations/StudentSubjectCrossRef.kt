package com.example.studentapp.models.relations

import androidx.room.Entity


@Entity(primaryKeys = ["studentId", "subjectId"])
data class StudentSubjectCrossRef(
    val studentId: Int,
    val subjectId: Int
)
