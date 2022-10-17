package com.example.studentapp.di.application

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.studentapp.daos.StudentDao
import com.example.studentapp.daos.SubjectDao
import com.example.studentapp.daos.TestDao
import com.example.studentapp.models.Student
import com.example.studentapp.models.Subject
import com.example.studentapp.models.Test
import com.example.studentapp.models.relations.StudentSubjectCrossRef
import com.example.studentapp.models.relations.StudentTestCrossRef

@Database(entities = [Subject::class, Student::class, Test::class, StudentSubjectCrossRef::class, StudentTestCrossRef::class], version = 2)
abstract class AppDatabase: RoomDatabase() {

    abstract fun subjectDao(): SubjectDao
    abstract fun studentDao(): StudentDao
    abstract fun testDao(): TestDao
}