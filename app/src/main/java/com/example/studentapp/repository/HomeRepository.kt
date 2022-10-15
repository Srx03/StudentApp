package com.example.studentapp.repository

import androidx.lifecycle.LiveData
import com.example.studentapp.models.Subject

interface HomeRepository {

    fun getAllSubjects(): LiveData<List<Subject>>
    suspend fun deleteSubject(id: String)
    suspend fun addSubject(subject: Subject)

}