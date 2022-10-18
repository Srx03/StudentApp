package com.example.studentapp.data.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.studentapp.data.entity.Test
import com.example.studentapp.data.entity.relations.StudentTestCrossRef
import com.example.studentapp.data.entity.relations.TestWithStudents


@Dao
interface TestDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTest(test: Test?)

    @Query("DELETE FROM test WHERE testId = :testId")
    suspend fun  deleteTest(testId: String?)

    @Query("SELECT * FROM test")
    fun getAllTests(): LiveData<List<Test>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudentTestCrossRef(crossRef: StudentTestCrossRef)

    @Transaction
    @Query("SELECT * FROM test WHERE testId = :id")
    suspend fun getStudentsOfTest(id: Int): List<TestWithStudents>


}