package com.example.studentapp.ui.addStudent

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studentapp.data.entity.Student
import com.example.studentapp.data.entity.Subject
import com.example.studentapp.util.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddStudentViewModel @Inject constructor(private val addStudentRepository: AddStudentRepository): ViewModel() {

    private val _validation  = Channel<AddStudentFieldsState>()
    val validation = _validation.receiveAsFlow()



    fun getStudentsByGender(gender: String) = addStudentRepository.getStudentsByGender(gender)

    fun getStudentsByNationality(nationality: String) =  addStudentRepository.getStudentsByNationality(nationality)

    fun getStudentsByCitizenship(citizenship: String) =  addStudentRepository.getStudentsByNationality(citizenship)

    fun getStudentsByAge() = addStudentRepository.getStudentsByAge()

    fun addStudent(student: Student) = viewModelScope.launch {

        if (checkValidation(student)){

            addStudentRepository.addStudent(student)

        }else{
            val validationCheck = AddStudentFieldsState(

            validateName(student.name),
            validateSurname(student.surename),
            validateEmail(student.email),
            validatePhone(student.phone),
            validateBirthday(student.birthday),
            validateAddress(student.address),
            validateGender(student.gender),
            validateNationality(student.nationality),
            validateCitizenship(student.citizenship)

            )

            _validation.send(validationCheck)

        }
    }


    private fun checkValidation(student: Student): Boolean {

        val nameValidaiton = validateName(student.name)
        val surenameValidaiton = validateSurname(student.surename)
        val emailValidaiton = validateEmail(student.email)
        val phoneValidaiton = validatePhone(student.phone)
        val birthdayValidaiton = validateBirthday(student.birthday)
        val addressValidaiton = validateAddress(student.address)
        val genderValidaiton = validateGender(student.gender)
        val nationalityValidaiton = validateNationality(student.nationality)
        val citizenshipValidaiton = validateCitizenship(student.citizenship)

        return nameValidaiton is Validation.Succes && surenameValidaiton is Validation.Succes && emailValidaiton is Validation.Succes
                && phoneValidaiton is Validation.Succes && birthdayValidaiton is Validation.Succes && addressValidaiton is Validation.Succes
                && genderValidaiton is Validation.Succes && nationalityValidaiton is Validation.Succes && citizenshipValidaiton is Validation.Succes
    }


}