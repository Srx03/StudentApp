package com.example.studentapp.repository

import com.example.studentapp.data.daos.StudentDao
import com.example.studentapp.data.entity.Student
import com.example.studentapp.data.entity.Subject
import javax.inject.Inject

class AddStudentRepositoryImpl @Inject constructor(private val studentDao: StudentDao): AddStudentRepository {

    override suspend fun addStudent(student: Student) {
        studentDao.addStudent(student)
    }
}