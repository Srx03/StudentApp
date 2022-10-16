package com.example.studentapp.models.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.studentapp.models.Student
import com.example.studentapp.models.Subject
import com.example.studentapp.models.Test

data class StudentWithTests(
    @Embedded val student: Student,
    @Relation(
        parentColumn = "studentId",
        entityColumn = "testId",
        associateBy = Junction(StudentTestCrossRef::class)
    )
    val tests: List<Test>
)
