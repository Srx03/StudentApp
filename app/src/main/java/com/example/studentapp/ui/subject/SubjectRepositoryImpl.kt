package com.example.studentapp.ui.subject

import androidx.lifecycle.LiveData
import com.example.studentapp.data.daos.StudentDao
import com.example.studentapp.data.daos.SubjectDao
import com.example.studentapp.data.daos.TestDao
import com.example.studentapp.data.entity.Student
import com.example.studentapp.data.entity.Subject
import com.example.studentapp.data.entity.Test
import com.example.studentapp.data.entity.relations.StudentSubjectCrossRef
import com.example.studentapp.data.entity.relations.SubjectWithStudents
import com.example.studentapp.data.entity.relations.SubjectWithTests
import com.example.studentapp.ui.home.HomeRepository
import com.example.studentapp.ui.search.SearchRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SubjectRepositoryImpl @Inject constructor(private val subjectDao: SubjectDao, private val testDao: TestDao, private val studentDao: StudentDao): SubjectRepository {

    override suspend fun addTest(test: Test) {
        testDao.addTest(test)
    }

    override suspend fun deleteTest(id: Int) {
        testDao.deleteTest(id)
    }

    override suspend fun addStudentToSubject(crossRef: StudentSubjectCrossRef) {
       subjectDao.insertStudentSubjectCrossRef(crossRef)
    }

    override fun getStudentsOfSubject(id: Int): LiveData<SubjectWithStudents>{
        return subjectDao.getStudetsOfSubject(id)
    }

    override fun getAllStudent(): LiveData<List<Student>> {
        return studentDao.getAllStudent()
    }

    override fun getAllTestsFromSubject(subjectId: Int): LiveData<List<SubjectWithTests>> {
        return testDao.getAllTestsFromSubject(subjectId)
    }

    override fun searchForStudents(searchQuery: String): Flow<List<Student>> {
        return studentDao.searchForStudents(searchQuery)
    }
}