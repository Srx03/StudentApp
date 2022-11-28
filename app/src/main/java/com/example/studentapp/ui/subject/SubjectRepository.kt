package com.example.studentapp.ui.subject

import androidx.lifecycle.LiveData
import com.example.studentapp.data.entity.Student
import com.example.studentapp.data.entity.Subject
import com.example.studentapp.data.entity.Test
import com.example.studentapp.data.entity.relations.StudentSubjectCrossRef
import com.example.studentapp.data.entity.relations.SubjectWithStudents
import com.example.studentapp.data.entity.relations.SubjectWithTests
import kotlinx.coroutines.flow.Flow

interface SubjectRepository {

    suspend fun addTest(test: Test)

    suspend fun deleteTest(id: Int)

    suspend fun  addStudentToSubject(crossRef: StudentSubjectCrossRef)

    fun getStudentsOfSubject(id: Int): LiveData<SubjectWithStudents>

    fun getAllStudent(): LiveData<List<Student>>

    fun getAllTestsFromSubject(subjectId: Int): LiveData<List<SubjectWithTests>>

    fun searchForStudents(searchQuery: String): Flow<List<Student>>


}