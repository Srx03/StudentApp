package com.example.studentapp.ui.subject

import androidx.lifecycle.LiveData
import com.example.studentapp.data.entity.Student
import com.example.studentapp.data.entity.Subject
import com.example.studentapp.data.entity.Test
import com.example.studentapp.data.entity.relations.StudentSubjectCrossRef
import com.example.studentapp.data.entity.relations.SubjectWithStudents
import com.example.studentapp.data.entity.relations.SubjectWithTests

interface SubjectRepository {

    suspend fun addTest(test: Test)

    suspend fun deleteTest(id: Int)

    suspend fun  addStudentToSubject(crossRef: StudentSubjectCrossRef)

    fun getStudentsOfSubject(id: Int): LiveData<List<SubjectWithStudents>>

    fun getAllStudent(): LiveData<List<Student>>

    fun getAllTestsFromSubject(subjectId: Int): LiveData<List<SubjectWithTests>>


}