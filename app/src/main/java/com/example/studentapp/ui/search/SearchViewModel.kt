package com.example.studentapp.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.studentapp.data.entity.Student
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor( private val searchRepository: SearchRepository): ViewModel() {

    private var getAllStudents: LiveData<List<Student>> = searchRepository.getAllStudent()

    fun getAllStudents() =  getAllStudents

}