package com.example.studentapp.ui.addStudent

import androidx.lifecycle.LiveData
import com.example.studentapp.data.daos.StudentDao
import com.example.studentapp.data.entity.Student
import javax.inject.Inject

class AddStudentRepositoryImpl @Inject constructor(private val studentDao: StudentDao):
    AddStudentRepository {

    override suspend fun addStudent(student: Student) {
        studentDao.addStudent(student)
    }

    override fun getStudentsByGender(gender: String): LiveData<List<Student>> {
        return studentDao.getStudentsByGender(gender)
    }

    override fun getStudentsByNationality(nationality: String): LiveData<List<Student>> {
        return studentDao.getStudentsByNationality(nationality)
    }

    override fun getStudentsByAge(): LiveData<List<Student>> {
        return studentDao.getStudentsByAge()
    }
}