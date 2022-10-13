package com.example.studentapp.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.studentapp.models.Student


@Dao
interface StudentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addStudent(student: Student?)

    @Query("DELETE FROM student_table WHERE id = :studentId")
    suspend fun  deleteStudent(studentId: String?)

    @Query("SELECT * FROM student_table")
    fun getAllStudent(): LiveData<List<Student>>

}