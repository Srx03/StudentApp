package com.example.studentapp.ui.search

import androidx.lifecycle.LiveData
import com.example.studentapp.data.daos.StudentDao
import com.example.studentapp.data.entity.Student
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(private val studentDao: StudentDao):
    SearchRepository {

    private lateinit var listOfAllStudents: LiveData<List<Student>>

    override fun getAllStudent(): LiveData<List<Student>> {
        listOfAllStudents = studentDao.getAllStudent()
        return listOfAllStudents
    }

    override fun searchForStudents(searchQuery: String): Flow<List<Student>>{
        return studentDao.searchForStudents(searchQuery)
    }
}