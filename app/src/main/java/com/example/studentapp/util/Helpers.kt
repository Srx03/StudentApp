package com.example.studentapp.util

import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*


fun TextView.formatDate(inputTime: String?) = if (!inputTime.isNullOrEmpty()) {
    // Making SDF object by giving input time pattern
    val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    // Parsing inputTime
    val parsedDate: Date? = sdf.parse(inputTime)
    // Formatting parsed input time/date
    val formattedTime = SimpleDateFormat("MMMM dd, yyyy", Locale.getDefault()).format(parsedDate)
    // Setting time to this textview
    this.text = "$formattedTime"
} else
    this.text = "Unknown"
