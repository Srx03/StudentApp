package com.example.studentapp.data.entity.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.studentapp.data.entity.Subject
import com.example.studentapp.data.entity.Test


data class SubjectWithTests(
    @Embedded val subject: Subject,
    @Relation(
        parentColumn = "subjectId",
        entityColumn = "subjectId"
    )
    val tests: List<Test>

)
