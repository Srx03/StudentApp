package com.example.studentapp.ui.subject

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.studentapp.data.entity.Test
import com.example.studentapp.data.entity.relations.StudentSubjectCrossRef
import com.example.studentapp.databinding.FragmentSubjectBinding
import com.example.studentapp.ui.search.SearchedStudentsAdapter
import com.example.studentapp.util.showSnackBar
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay

class SubjectFragment : Fragment() {


    private var _binding: FragmentSubjectBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SubjectViewModel by activityViewModels()
    private lateinit var addedStudentsAdapter: AddedStudentsAdapter
    private lateinit var studentsToAddAdapter: StudentsToAddAdapter
    private lateinit var searchedInSubjectStudentsAdapter: SearchedInSubjectStudentsAdapter
    private lateinit var testAdapter: TestAdapter
    private var subjectId: Int = 0
     private lateinit var subjectName: String
    private var searchQuery: String? = null
    private var job: Job? = null

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
        subjectId = args?.getInt("subjectId")!!
        Log.d("subjectId",subjectId.toString())
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

          Log.d("setlist",it.toString())

      }

        viewModel.getStudentsOfSubject(subjectId).observe(viewLifecycleOwner){

                Log.d("puno",it.toString())


        }




        binding.etSearch.doOnTextChanged { text, _, _, _ ->
            text?.let {

                searchQuery = it.trim().toString()
                binding.apply {
                    if (it.isNotEmpty() && it.isNotBlank()) {
                        searchingProgressBar.isGone = false
                        emptySearch.isGone = true
                        allStudentRecyclerView.isGone = true
                        searchedRecyclerView.isGone = true // Make it visible on getting results
                        performSearch(it.trim().toString())

                        viewModel.searchForStudents(searchQuery!!).observe(viewLifecycleOwner){

                            Log.d("top", it.toString())

                            if (it.isNotEmpty()){
                                setupSearchedRecyclerView()
                                searchedInSubjectStudentsAdapter.setList(it)
                                bindingSetupSearch()

                                Log.d("top1", it.toString())

                            }else {
                                binding.emptySearch.isGone = false
                                searchingProgressBar.isGone = true
                            }

                        }


                    } else {
                        viewModel.getAllStudent()
                        allStudentRecyclerView.isGone = false
                        searchedRecyclerView.isGone = true
                        searchingProgressBar.isGone = true
                        emptySearch.isGone = true


                        // also cancel the job
                        job?.cancel()
                    }
                }
            }
        }

        testAdapter.setOnTestClick {
            viewModel.deleteTest(it.tests[subjectId].testId)
            Log.d("HAJDE",it.tests[subjectId].testId.toString())
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
            layoutManager = LinearLayoutManager(context,  LinearLayoutManager.HORIZONTAL, false)
        }

    }

    fun setupSearchedRecyclerView(){

        searchedInSubjectStudentsAdapter = SearchedInSubjectStudentsAdapter()

        binding.searchedRecyclerView.apply {
            adapter = searchedInSubjectStudentsAdapter
            layoutManager = LinearLayoutManager(context,  LinearLayoutManager.VERTICAL, false)
        }

    }

    private fun performSearch(searchQuery: String) {
        job?.cancel()
        job = viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            // first let's wait for change in input search query
            delay(800)
            viewModel.searchForStudents(searchQuery)
        }
    }

    private fun bindingSetupSearch(){
        binding.searchedRecyclerView.isGone = false
        binding.searchingProgressBar.isGone = true
        binding.allStudentRecyclerView.isGone = true
        binding.emptySearch.isGone = true
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}