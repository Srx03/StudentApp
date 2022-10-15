package com.example.studentapp.repository

import androidx.lifecycle.LiveData
import com.example.studentapp.daos.SubjectDao
import com.example.studentapp.models.Subject
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(val subjectDao: SubjectDao): HomeRepository {

    override fun getAllSubjects(): LiveData<List<Subject>> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteSubject(id: String) {
        TODO("Not yet implemented")
    }
}