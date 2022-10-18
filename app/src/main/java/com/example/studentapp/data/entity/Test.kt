package com.example.studentapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Test(
    @PrimaryKey(autoGenerate = true)
    var testId: Int = 0,
    var name: String,

)
