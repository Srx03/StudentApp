package com.example.studentapp.data.entity.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.studentapp.data.entity.Student
import com.example.studentapp.data.entity.Test

data class TestWithStudents(
    @Embedded val test: Test,
    @Relation(
        parentColumn = "testId",
        entityColumn = "studentId",
        associateBy = Junction(StudentTestCrossRef::class)
    )
    val students: List<Student>
)
