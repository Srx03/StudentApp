package com.example.studentapp.models.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.studentapp.models.Student
import com.example.studentapp.models.Subject
import com.example.studentapp.models.Test

data class TestWithStudents(
    @Embedded val test: Test,
    @Relation(
        parentColumn = "testId",
        entityColumn = "studentId",
        associateBy = Junction(StudentTestCrossRef::class)
    )
    val students: List<Student>
)
