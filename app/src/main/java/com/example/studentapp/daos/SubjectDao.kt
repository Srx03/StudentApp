package com.example.studentapp.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.studentapp.models.Subject


@Dao
interface SubjectDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addSubject(subject: Subject?)

    @Query("DELETE FROM subject_table WHERE id = :subjectId")
    suspend fun  deleteSubject(subjectId: String?)

    @Query("SELECT * FROM subject_table")
    fun getAllSubject(): LiveData<List<Subject>>

}