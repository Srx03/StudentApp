package com.example.studentapp.ui.subject

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.studentapp.data.entity.Test
import com.example.studentapp.data.entity.relations.StudentSubjectCrossRef
import com.example.studentapp.databinding.FragmentSubjectBinding

class SubjectFragment : Fragment() {


    private var _binding: FragmentSubjectBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SubjectViewModel by activityViewModels()
    private lateinit var addedStudentsAdapter: AddedStudentsAdapter
    private lateinit var studentsToAddAdapter: StudentsToAddAdapter
    private lateinit var testAdapter: TestAdapter
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

        setupRecyclerView()

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

            btnAdd.setOnClickListener {
                val test = Test(
                    0,
                    binding.testNameEditText.text.toString(),
                    binding.dateEditText.text.toString(),
                    binding.timeEditText.text.toString(),
                    subjectId,
                    subjectName
                )

                viewModel.addTest(test)
            }



        }



        studentsToAddAdapter.setOnStudentAddClick {

            val crossRef = StudentSubjectCrossRef(
                it.studentId,
                subjectId
            )

            viewModel.addStudentToSubject(crossRef)
            Log.d("studentiadd",it.toString())
        }

        viewModel.getAllStudent().observe(viewLifecycleOwner){
            studentsToAddAdapter.setList(it)
        }

      viewModel.getAllTestsFromSubject(subjectId).observe(viewLifecycleOwner){
          testAdapter.setList(it)
      }



    }

    fun setupRecyclerView(){
        addedStudentsAdapter = AddedStudentsAdapter()
        studentsToAddAdapter = StudentsToAddAdapter()
        testAdapter = TestAdapter()

        binding.studentInSubjectsRecyclerView.apply {
            adapter = addedStudentsAdapter
            layoutManager = LinearLayoutManager(context,  LinearLayoutManager.VERTICAL, false)
        }

        binding.allStudentRecyclerView.apply {
            adapter = studentsToAddAdapter
            layoutManager = LinearLayoutManager(context,  LinearLayoutManager.VERTICAL, false)
        }

        binding.testRecyclerView.apply {
            adapter = testAdapter
            layoutManager = LinearLayoutManager(context,  LinearLayoutManager.VERTICAL, false)
        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}