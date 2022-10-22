package com.example.studentapp.ui.addStudent

import com.example.studentapp.data.daos.StudentDao
import com.example.studentapp.data.entity.Student
import javax.inject.Inject

class AddStudentRepositoryImpl @Inject constructor(private val studentDao: StudentDao):
    AddStudentRepository {

    override suspend fun addStudent(student: Student) {
        studentDao.addStudent(student)
    }
}