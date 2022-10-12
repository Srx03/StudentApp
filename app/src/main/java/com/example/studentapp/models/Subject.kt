package com.example.studentapp.models

data class Subject(
    var id: String,
    var subjectName: String,
    var studentsInSubject: List<Student>,
    var number: String,
    var testInSubject: List<Test>,



)