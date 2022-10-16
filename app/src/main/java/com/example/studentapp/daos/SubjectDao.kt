package com.example.studentapp.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.studentapp.models.Subject
import com.example.studentapp.models.relations.StudentSubjectCrossRef
import com.example.studentapp.models.relations.SubjectWithStudents
import com.example.studentapp.models.relations.SubjectWithTests


@Dao
interface SubjectDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addSubject(subject: Subject?)

    @Query("DELETE FROM subject WHERE subjectId = :subjectId")
    suspend fun  deleteSubject(subjectId: String?)

    @Query("SELECT * FROM subject")
    fun getAllSubject(): LiveData<List<Subject>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudentSubjectCrossRef(crossRef: StudentSubjectCrossRef)

    @Transaction
    @Query("SELECT * FROM subject WHERE subjectId = :id")
    suspend fun getStudetsOfSubject(id: Int): List<SubjectWithStudents>

    @Transaction
    @Query("SELECT * FROM subject WHERE subjectId = :id")
    suspend fun getTestsOfSubject(id: Int): List<SubjectWithTests>


}