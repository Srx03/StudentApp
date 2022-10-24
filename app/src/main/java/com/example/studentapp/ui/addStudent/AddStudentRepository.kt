package com.example.studentapp.ui.addStudent

import androidx.lifecycle.LiveData
import com.example.studentapp.data.entity.Student
import com.example.studentapp.data.entity.Subject

interface AddStudentRepository {

    suspend fun addStudent(student: Student)

    fun getStudentsByGender(gender: String): LiveData<List<Student>>

    fun getStudentsByNationality(nationality: String): LiveData<List<Student>>

    fun getStudentsByAge(): LiveData<List<Student>>

}