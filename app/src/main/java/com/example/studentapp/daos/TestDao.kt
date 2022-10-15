package com.example.studentapp.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.studentapp.models.Student
import com.example.studentapp.models.Test


@Dao
interface TestDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTest(test: Test?)

    @Query("DELETE FROM test_table WHERE id = :testId")
    suspend fun  deleteTest(testId: String?)

    @Query("SELECT * FROM test_table")
    fun getAllTests(): LiveData<List<Test>>

}