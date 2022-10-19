package com.example.studentapp.util

import android.util.Patterns
import com.example.studentapp.data.entity.Student


fun validateName(name: String): Validation{
    if (name.isEmpty())
        return Validation.Failed("Name is required")

    return Validation.Succes
}

fun validateSurname(surename: String): Validation{
    if (surename.isEmpty())
        return Validation.Failed("Surename is required")

    return Validation.Succes
}

fun validateEmail(email: String): Validation{
    if (email.isEmpty())
        return Validation.Failed("Email is required")

    if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        return Validation.Failed("Wrong is required")

    return Validation.Succes
}

fun validatePhone(phone: String): Validation{
    if (phone.isEmpty())
        return Validation.Failed("Phone is required")

    return Validation.Succes
}

fun validateBirthday(birthday: String): Validation{
    if (birthday.isEmpty())
        return Validation.Failed("Birthday is required")

    return Validation.Succes
}

fun validateAddress(address: String): Validation{
    if (address.isEmpty())
        return Validation.Failed("Address is required")

    return Validation.Succes
}

fun validateGender(gender: String): Validation{
    if (gender.isEmpty())
        return Validation.Failed("Gender is required")

    return Validation.Succes
}

fun validateNationality(nationality: String): Validation{
    if (nationality.isEmpty())
        return Validation.Failed("Nationality is required")

    return Validation.Succes
}

fun validateCitizenship(citizenship: String): Validation{
    if (citizenship.isEmpty())
        return Validation.Failed("Citizenship is required")

    return Validation.Succes
}
