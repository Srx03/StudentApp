package com.example.studentapp.repository

import androidx.lifecycle.LiveData
import com.example.studentapp.data.daos.StudentDao
import com.example.studentapp.data.daos.SubjectDao
import com.example.studentapp.data.entity.Student
import com.example.studentapp.data.entity.Subject
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(private val studentDao: StudentDao): SearchRepository {

    private lateinit var listOfAllStudents: LiveData<List<Student>>

    override fun getAllStudent(): LiveData<List<Student>> {
        listOfAllStudents = studentDao.getAllStudent()
        return listOfAllStudents
    }

}