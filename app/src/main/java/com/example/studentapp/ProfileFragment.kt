package com.example.studentapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isGone
import androidx.fragment.app.activityViewModels
import com.example.studentapp.data.entity.Student

import com.example.studentapp.databinding.FragmentProfileBinding
import com.example.studentapp.util.showSnackBar
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ProfileFragment :  BottomSheetDialogFragment() {


    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

   var studenId: Int = 0
    lateinit var name: String
    lateinit var surename: String
    lateinit var email: String
    lateinit var phone: String
    lateinit var birthday: String
    lateinit var address: String
    lateinit var gender: String
    lateinit var nationality: String
    lateinit var citizenship: String

    private val viewModel: AddStudentViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            btnClose.setOnClickListener {
                dismiss()
            }

            val args = arguments
            studenId = args?.getInt("id")!!
            name = args.getString("name").toString()
            surename = args.getString("surename").toString()
            email = args.getString("email").toString()
            phone = args.getString("phone").toString()
            birthday = args.getString("birthday").toString()
            address = args.getString("address").toString()
            gender = args.getString("gender").toString()
            nationality = args.getString("nationality").toString()
            citizenship = args.getString("citizenship").toString()



            nameEditText.setText(name)
            surenameEditText.setText(surename)
            emailEditText.setText(email)
            birthdayEditText.setText(phone)
            phonelEditText.setText(birthday)
            addressEditText.setText(address)
            genderEditText.setText(gender)
            nationalityEditText.setText(nationality)
            citizenshipEditText.setText(citizenship)


            btnSave.setOnClickListener {
                val student = Student(
                    studenId,
                    nameEditText.text.toString(),
                    surenameEditText.text.toString(),
                    emailEditText.text.toString(),
                    birthdayEditText.text.toString(),
                    phonelEditText.text.toString(),
                    addressEditText.text.toString(),
                    genderEditText.text.toString(),
                    nationalityEditText.text.toString(),
                    citizenshipEditText.text.toString()

                )
                viewModel.addStudent(student)

                Toast.makeText(requireContext(), "Succesfully edited", Toast.LENGTH_SHORT)
            }

            btnCloseSelectedEditText.setOnClickListener {
                selectWhatToEditLayout.isGone = false
                selectedEditTextLayout.isGone = true
            }

            nameEditText.setOnClickListener {
                selectWhatToEditLayout.isGone = true
                selectedEditTextLayout.isGone = false

                currentlyEditing.text = "Name"

                selectedEditText.text = nameEditText.text

                btnCloseSelectedEditText.setOnClickListener {
                    if (selectedEditText.text.isNullOrBlank())
                        showSnackBar(message = "Please add name if you want to change it")
                    else {
                        nameEditText.text = selectedEditText.text
                        selectWhatToEditLayout.isGone = false
                        selectedEditTextLayout.isGone = true
                    }

                }

            }


            surenameEditText.setOnClickListener {
                selectWhatToEditLayout.isGone = true
                selectedEditTextLayout.isGone = false

                currentlyEditing.text = "Surename"

                selectedEditText.text = surenameEditText.text

                btnCloseSelectedEditText.setOnClickListener {
                    if (selectedEditText.text.isNullOrBlank())
                        showSnackBar(message = "Please add surename if you want to change it")
                    else {
                        surenameEditText.text = selectedEditText.text
                        selectWhatToEditLayout.isGone = false
                        selectedEditTextLayout.isGone = true
                    }

                }

            }


            emailEditText.setOnClickListener {
                selectWhatToEditLayout.isGone = true
                selectedEditTextLayout.isGone = false

                currentlyEditing.text = "Email"

                selectedEditText.text = emailEditText.text

                btnSaveSelectedEditText.setOnClickListener {
                    if (selectedEditText.text.isNullOrBlank())
                        showSnackBar(message = "Please add email if you want to change it")
                    else {
                        emailEditText.text = selectedEditText.text
                        selectWhatToEditLayout.isGone = false
                        selectedEditTextLayout.isGone = true
                    }

                }

            }


            phonelEditText.setOnClickListener {
                selectWhatToEditLayout.isGone = true
                selectedEditTextLayout.isGone = false

                currentlyEditing.text = "Phone"

                selectedEditText.text = phonelEditText.text

                btnSaveSelectedEditText.setOnClickListener {
                    if (selectedEditText.text.isNullOrBlank())
                        showSnackBar(message = "Please add phone if you want to change it")
                    else {
                        phonelEditText.text = selectedEditText.text
                        selectWhatToEditLayout.isGone = false
                        selectedEditTextLayout.isGone = true
                    }

                }

            }


            birthdayEditText.setOnClickListener {
                selectWhatToEditLayout.isGone = true
                selectedEditTextLayout.isGone = false

                currentlyEditing.text = "Birthday"

                selectedEditText.text = birthdayEditText.text

                btnSaveSelectedEditText.setOnClickListener {
                    if (selectedEditText.text.isNullOrBlank())
                        showSnackBar(message = "Please add birthday if you want to change it")
                    else {
                        birthdayEditText.text = selectedEditText.text
                        selectWhatToEditLayout.isGone = false
                        selectedEditTextLayout.isGone = true
                    }

                }

            }


            addressEditText.setOnClickListener {
                selectWhatToEditLayout.isGone = true
                selectedEditTextLayout.isGone = false

                currentlyEditing.text = "Address"

                selectedEditText.text = addressEditText.text

                btnSaveSelectedEditText.setOnClickListener {
                    if (selectedEditText.text.isNullOrBlank())
                        showSnackBar(message = "Please add address if you want to change it")
                    else {
                        addressEditText.text = selectedEditText.text
                        selectWhatToEditLayout.isGone = false
                        selectedEditTextLayout.isGone = true
                    }

                }

            }


            genderEditText.setOnClickListener {
                selectWhatToEditLayout.isGone = true
                selectedEditTextLayout.isGone = false

                currentlyEditing.text = "Gender"

                selectedEditText.text = genderEditText.text

                btnSaveSelectedEditText.setOnClickListener {
                    if (selectedEditText.text.isNullOrBlank())
                        showSnackBar(message = "Please add gender if you want to change it")
                    else {
                        genderEditText.text = selectedEditText.text
                        selectWhatToEditLayout.isGone = false
                        selectedEditTextLayout.isGone = true
                    }

                }

            }


            nationalityEditText.setOnClickListener {
                selectWhatToEditLayout.isGone = true
                selectedEditTextLayout.isGone = false

                currentlyEditing.text = "Nationality"

                selectedEditText.text = nationalityEditText.text

                btnSaveSelectedEditText.setOnClickListener {
                    if (selectedEditText.text.isNullOrBlank())
                        showSnackBar(message = "Please add nationality if you want to change it")
                    else {
                        nationalityEditText.text = selectedEditText.text
                        selectWhatToEditLayout.isGone = false
                        selectedEditTextLayout.isGone = true
                    }
                }

            }

           citizenshipEditText.setOnClickListener {
                selectWhatToEditLayout.isGone = true
                selectedEditTextLayout.isGone = false

                currentlyEditing.text = "Citizenship"

                selectedEditText.text = citizenshipEditText.text

               btnSaveSelectedEditText.setOnClickListener {
                    if (selectedEditText.text.isNullOrBlank())
                        showSnackBar(message = "Please add citizenship if you want to change it")
                    else {
                        citizenshipEditText.text = selectedEditText.text
                        selectWhatToEditLayout.isGone = false
                        selectedEditTextLayout.isGone = true
                    }

                }

            }

        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}