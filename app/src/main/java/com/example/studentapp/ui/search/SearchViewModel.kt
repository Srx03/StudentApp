package com.example.studentapp.ui.search

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.studentapp.data.entity.Student
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor( private val searchRepository: SearchRepository): ViewModel() {

    private var getAllStudents: LiveData<List<Student>> = searchRepository.getAllStudent()




    fun getAllStudents() =  getAllStudents

    fun searchForStudents(searchQuery: String):  LiveData<List<Student>>{

        Log.d("topic", searchRepository.searchForStudents(searchQuery).asLiveData().toString())

        return searchRepository.searchForStudents(searchQuery).asLiveData()
    }

}