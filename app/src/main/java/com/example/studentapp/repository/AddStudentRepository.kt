package com.example.studentapp.repository

import androidx.lifecycle.LiveData
import com.example.studentapp.data.entity.Student
import com.example.studentapp.data.entity.Subject

interface AddStudentRepository {

    suspend fun addStudent(student: Student)

}