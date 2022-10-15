package com.example.studentapp.repository

import androidx.lifecycle.LiveData
import com.example.studentapp.daos.SubjectDao
import com.example.studentapp.models.Subject
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(private val subjectDao: SubjectDao): HomeRepository {

    private lateinit var listOfSubjects:LiveData<List<Subject>>


    override fun getAllSubjects(): LiveData<List<Subject>> {
        listOfSubjects = subjectDao.getAllSubject()
        return listOfSubjects
    }

    override suspend fun deleteSubject(id: String) {
        subjectDao.deleteSubject(id)
    }

    override suspend fun addSubject(subject: Subject) {
        subjectDao.addSubject(subject)
    }
}