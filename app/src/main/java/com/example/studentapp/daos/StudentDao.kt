package com.example.studentapp.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.studentapp.models.Student
import com.example.studentapp.models.relations.StudentWithSubjects
import com.example.studentapp.models.relations.StudentWithTests


@Dao
interface StudentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addStudent(student: Student?)

    @Query("DELETE FROM student WHERE studentId = :studentId")
    suspend fun  deleteStudent(studentId: String?)

    @Query("SELECT * FROM student")
    fun getAllStudent(): LiveData<List<Student>>


    @Transaction
    @Query("SELECT * FROM student WHERE studentId = :id")
    suspend fun getSubjectsOfStudent(id: Int): List<StudentWithSubjects>

    @Transaction
    @Query("SELECT * FROM student WHERE studentId = :id")
    suspend fun getTestsOfStudent(id: Int): List<StudentWithTests>


}