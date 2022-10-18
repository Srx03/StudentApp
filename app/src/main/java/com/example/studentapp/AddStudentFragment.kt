package com.example.studentapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.studentapp.data.entity.Student
import com.example.studentapp.data.entity.Subject
import com.example.studentapp.databinding.FragmentAddStudentBinding
import dagger.hilt.android.AndroidEntryPoint

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

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}