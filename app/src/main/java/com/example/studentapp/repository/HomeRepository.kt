package com.example.studentapp.repository

import androidx.lifecycle.LiveData
import com.example.studentapp.data.entity.Subject

interface HomeRepository {

    fun getAllSubjects(): LiveData<List<Subject>>
    suspend fun deleteSubject(id: Int)
    suspend fun addSubject(subject: Subject)

}