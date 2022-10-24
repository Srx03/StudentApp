package com.example.studentapp.ui.search

import androidx.lifecycle.LiveData
import com.example.studentapp.data.entity.Student
import com.example.studentapp.data.entity.Subject
import kotlinx.coroutines.flow.Flow

interface SearchRepository {

    fun getAllStudent(): LiveData<List<Student>>
    fun searchForStudents(searchQuery: String): Flow<List<Student>>

}