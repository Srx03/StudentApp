package com.example.studentapp.ui.subject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.fragment.app.activityViewModels
import com.example.studentapp.data.entity.Test
import com.example.studentapp.databinding.FragmentSearchBinding
import com.example.studentapp.databinding.FragmentSubjectBinding

class SubjectFragment : Fragment() {


    private var _binding: FragmentSubjectBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SubjectViewModel by activityViewModels()

    private var subjectId: Int = 0
     private lateinit var subjectName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSubjectBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = arguments
        subjectId = args?.getInt("id")!!
        subjectName = args.getString("subjectName")!!

        binding.apply {

            tvSubject.text = subjectName

            btnAddStudent.setOnClickListener {
                layoutSearch.isGone = false
                layoutAddTest.isGone = true
            }

            btnAddTest.setOnClickListener {
                layoutSearch.isGone = true
                layoutAddTest.isGone = false
            }

        }

        val test = Test(
            0,
            binding.testNameEditText.text.toString(),
            binding.dateEditText.text.toString(),
            binding.timeEditText.text.toString(),
            subjectId
        )

        viewModel.addTest(test)

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}