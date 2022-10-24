package com.example.studentapp.data.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.studentapp.data.entity.Student
import com.example.studentapp.data.entity.relations.StudentWithSubjects
import com.example.studentapp.data.entity.relations.StudentWithTests
import kotlinx.coroutines.flow.Flow


@Dao
interface StudentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addStudent(student: Student?)

    @Query("DELETE FROM student WHERE studentId = :studentId")
    suspend fun  deleteStudent(studentId: String?)

    @Query("SELECT * FROM student")
    fun getAllStudent(): LiveData<List<Student>>

    @Query("SELECT * FROM student WHERE name LIKE '%' || :searchQuery || '%'")
    fun searchForStudents(searchQuery: String): Flow<List<Student>>


    @Transaction
    @Query("SELECT * FROM student WHERE studentId = :id")
    suspend fun getSubjectsOfStudent(id: Int): List<StudentWithSubjects>

    @Transaction
    @Query("SELECT * FROM student WHERE studentId = :id")
    suspend fun getTestsOfStudent(id: Int): List<StudentWithTests>


}