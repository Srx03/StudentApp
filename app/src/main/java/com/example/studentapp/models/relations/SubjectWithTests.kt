package com.example.studentapp.models.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.studentapp.models.Subject
import com.example.studentapp.models.Test


data class SubjectWithTests(
    @Embedded val subject: Subject,
    @Relation(
        parentColumn = "subjectId",
        entityColumn = "subjectId"
    )
    val tests: List<Test>

)
