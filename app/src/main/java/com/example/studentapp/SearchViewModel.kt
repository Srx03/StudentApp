package com.example.studentapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studentapp.data.entity.Student
import com.example.studentapp.repository.SearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor( private val searchRepository: SearchRepository): ViewModel() {

    private var getAllStudents: LiveData<List<Student>> = searchRepository.getAllStudent()

    fun getAllStudents() =  getAllStudents

}