package com.example.studentapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Test(
    @PrimaryKey(autoGenerate = true)
    var testId: Int? = null,
    var name: String,

)
