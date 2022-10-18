package com.example.studentapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studentapp.data.entity.Student
import com.example.studentapp.repository.AddStudentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddStudentViewModel @Inject constructor(private val addStudentRepository: AddStudentRepository): ViewModel() {

    fun addStudent(student: Student) = viewModelScope.launch {
        addStudentRepository.addStudent(student)
    }


}