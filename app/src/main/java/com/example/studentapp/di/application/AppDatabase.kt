package com.example.studentapp.di.application

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.studentapp.daos.StudentDao
import com.example.studentapp.daos.SubjectDao
import com.example.studentapp.daos.TestDao
import com.example.studentapp.models.Student
import com.example.studentapp.models.Subject
import com.example.studentapp.models.Test

@Database(entities = [Subject::class, Student::class, Test::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun subjectDao(): SubjectDao
    abstract fun studentDao(): StudentDao
    abstract fun testDao(): TestDao
}