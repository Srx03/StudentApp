package com.example.studentapp.data.entity.relations

import androidx.room.Entity


@Entity(primaryKeys = ["studentId", "testId"])
data class StudentTestCrossRef(
    val studentId: Int,
    val testId: Int
)
