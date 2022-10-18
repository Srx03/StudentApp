package com.example.studentapp.data.daos

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.studentapp.data.entity.Student
import com.example.studentapp.data.entity.Subject
import com.example.studentapp.data.entity.Test
import com.example.studentapp.data.entity.relations.StudentSubjectCrossRef
import com.example.studentapp.data.entity.relations.StudentTestCrossRef

@Database(entities = [Subject::class, Student::class, Test::class, StudentSubjectCrossRef::class, StudentTestCrossRef::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun subjectDao(): SubjectDao
    abstract fun studentDao(): StudentDao
    abstract fun testDao(): TestDao
}