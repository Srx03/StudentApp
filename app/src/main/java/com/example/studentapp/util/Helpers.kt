package com.example.studentapp.util

import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
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



fun View.showSnackBar(
    message: String,
    length: Int = Snackbar.LENGTH_LONG,
    actionMsg: String? = null,
    action: (() -> Unit)? = null
) {
    Snackbar.make(this, message, length).apply {
        actionMsg?.let {
            setAction(actionMsg) {
                action?.invoke()
            }
        }
        show()
    }
}

fun Fragment.showSnackBar(
    message: String?,
    length: Int = Snackbar.LENGTH_LONG,
    actionMsg: String? = null,
    action: (() -> Unit)? = null
) = requireView().showSnackBar(
    message = message!!,
    action = action,
    actionMsg = actionMsg,
    length = length
)
