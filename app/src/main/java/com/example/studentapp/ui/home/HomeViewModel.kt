package com.example.studentapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studentapp.data.entity.Subject
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

    fun deleteSubject(id: Int) = viewModelScope.launch {

        homeRepository.deleteSubject(id)

    }



}