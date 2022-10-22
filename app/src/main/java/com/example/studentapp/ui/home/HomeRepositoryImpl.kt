package com.example.studentapp.ui.home

import androidx.lifecycle.LiveData
import com.example.studentapp.data.daos.SubjectDao
import com.example.studentapp.data.entity.Subject
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(private val subjectDao: SubjectDao): HomeRepository {




    override fun getAllSubjects(): LiveData<List<Subject>> {
        return subjectDao.getAllSubject()
    }

    override suspend fun deleteSubject(id: Int) {
        subjectDao.deleteSubject(id)
    }

    override suspend fun addSubject(subject: Subject) {
        subjectDao.addSubject(subject)
    }
}