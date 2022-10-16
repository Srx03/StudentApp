package com.example.studentapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studentapp.models.Subject
import com.example.studentapp.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor (private val homeRepository: HomeRepository): ViewModel() {

    private var listOfSubjects: LiveData<List<Subject>> = homeRepository.getAllSubjects()

    fun getAllSubjects() = listOfSubjects

    fun addSubject(subject: Subject) = viewModelScope.launch {

        homeRepository.addSubject(subject)

    }

    fun deleteSubject(id: String) = viewModelScope.launch {

        homeRepository.deleteSubject(id)

    }



}