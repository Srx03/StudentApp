package com.example.studentapp.ui.subject

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studentapp.data.entity.Student
import com.example.studentapp.data.entity.Test
import com.example.studentapp.data.entity.relations.StudentSubjectCrossRef
import com.example.studentapp.data.entity.relations.SubjectWithTests
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SubjectViewModel @Inject constructor(private val subjectRepository: SubjectRepository): ViewModel() {


    fun getStudentsOfSubject(subjectId: Int) = subjectRepository.getStudentsOfSubject(subjectId)

    fun addTest(test: Test) = viewModelScope.launch {
        subjectRepository.addTest(test)
    }

    fun deleteTest(id: Int) = viewModelScope.launch {
        subjectRepository.deleteTest(id)
    }

    fun  addStudentToSubject(crossRef: StudentSubjectCrossRef) = viewModelScope.launch {
        subjectRepository.addStudentToSubject(crossRef)
    }

    fun getAllStudent() = subjectRepository.getAllStudent()

    fun getAllTestsFromSubject(subjectId: Int) = subjectRepository.getAllTestsFromSubject(subjectId)




}