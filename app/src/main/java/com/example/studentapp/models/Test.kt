package com.example.studentapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "test_table")
class Test(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var name: String,
    var subjectId: String
)
