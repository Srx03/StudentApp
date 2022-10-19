package com.example.studentapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.studentapp.data.entity.Student
import com.example.studentapp.data.entity.Subject
import com.example.studentapp.databinding.FragmentAddStudentBinding
import com.example.studentapp.util.Validation
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class AddStudentFragment : Fragment() {


    private var _binding: FragmentAddStudentBinding? = null
    private val binding get() = _binding!!

    private val  viewModel: AddStudentViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddStudentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            btnAdd.setOnClickListener {

                val student = Student(
                    0,
                    nameEditText.text.toString(),
                    surnameEditText.text.toString(),
                    emailEditText.text.toString(),
                    birthdayEditText.text.toString(),
                    phonelEditText.text.toString(),
                    addressEditText.text.toString(),
                    genderEditText.text.toString(),
                    nationalityEditText.text.toString(),
                    citizenshipEditText.text.toString(),


                    )
                viewModel.addStudent(student)
            }

        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.validation.collect { validation ->

                if (validation.name is Validation.Failed) {
                    withContext(Dispatchers.Main) {
                        binding.emailEditText.apply {
                            requestFocus()
                            binding.nameInputLayout.helperText = validation.name.message
                        }
                    }
                }

                if (validation.surename is Validation.Failed) {
                    withContext(Dispatchers.Main) {
                        binding.emailEditText.apply {
                            requestFocus()
                            binding.surnameInputLayout.helperText = validation.surename.message
                        }
                    }
                }


                if (validation.email is Validation.Failed) {
                    withContext(Dispatchers.Main) {
                        binding.emailEditText.apply {
                            requestFocus()
                            binding.emailInputLayout.helperText = validation.email.message
                        }
                    }
                }


                if (validation.phone is Validation.Failed) {
                    withContext(Dispatchers.Main) {
                        binding.phonelEditText.apply {
                            requestFocus()
                            binding.phoneInputLayout.helperText = validation.phone.message
                        }
                    }
                }


                if (validation.birthday is Validation.Failed) {
                    withContext(Dispatchers.Main) {
                        binding.birthdayEditText.apply {
                            requestFocus()
                            binding.birthdayInputLayout.helperText = validation.birthday.message
                        }
                    }
                }


                if (validation.address is Validation.Failed) {
                    withContext(Dispatchers.Main) {
                        binding.addressEditText.apply {
                            requestFocus()
                            binding.addressInputLayout.helperText = validation.address.message
                        }
                    }
                }

                if (validation.gender is Validation.Failed) {
                    withContext(Dispatchers.Main) {
                        binding.genderEditText.apply {
                            requestFocus()
                            binding.genderInputLayout.helperText = validation.gender.message
                        }
                    }
                }

               if (validation.nationality is Validation.Failed) {
                    withContext(Dispatchers.Main) {
                        binding.nationalityEditText.apply {
                            requestFocus()
                            binding.nationalityInputLayout.helperText = validation.nationality.message
                        }
                    }
                }

                if (validation.citizenship is Validation.Failed) {
                    withContext(Dispatchers.Main) {
                        binding.citizenshipEditText.apply {
                            requestFocus()
                            binding.citizenshipInputLayout.helperText = validation.citizenship.message
                        }
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