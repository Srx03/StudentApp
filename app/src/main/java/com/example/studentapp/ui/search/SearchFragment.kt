package com.example.studentapp.ui.search

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
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.studentapp.R
import com.example.studentapp.databinding.FragmentSearchBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay

@AndroidEntryPoint
class SearchFragment : Fragment() {


    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private lateinit var allStudentsAdapter: AllStudentsAdapter
    private lateinit var searchedStudentsAdapter: SearchedStudentsAdapter
    private val  viewModel: SearchViewModel by activityViewModels()

    private var searchQuery: String? = null
    private var job: Job? = null



        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.getAllStudents().observe(viewLifecycleOwner){

            allStudentsAdapter.setList(it)

        }




        binding.etSearch.doOnTextChanged { text, _, _, _ ->
            text?.let {

                searchQuery = it.trim().toString()
                binding.apply {
                    if (it.isNotEmpty() && it.isNotBlank()) {
                        // Show searching progress bar
                        tvPresenting.text = "Presenting searched students"
                        searchingProgressBar.isGone = false
                        emptySearch.isGone = true
                        allRecyclerView.isGone = true
                        searchRecyclerView.isGone = true // Make it visible on getting results
                        performSearch(it.trim().toString())

                        viewModel.searchForStudents(searchQuery!!).observe(viewLifecycleOwner){

                            Log.d("top", it.toString())

                            if (it.isNotEmpty()){
                                setupSearchedRecyclerView()
                                searchedStudentsAdapter.setList(it)
                                bindingSetupSearch()

                                Log.d("top1", it.toString())

                            }else binding.emptySearch.isGone = false

                        }


                    } else {
                        viewModel.getAllStudents()
                        allRecyclerView.isGone = false
                        searchRecyclerView.isGone = true
                        searchingProgressBar.isGone = true
                        emptySearch.isGone = true

                        tvPresenting.text = "Presenting all students"

                        // also cancel the job
                        job?.cancel()
                    }
                }
            }
        }



        setupRecyclerView()
        onStudentClick()

    }


    fun setupRecyclerView(){
        allStudentsAdapter = AllStudentsAdapter()

        binding.allRecyclerView.apply {
            adapter = allStudentsAdapter
            layoutManager = LinearLayoutManager(context,  LinearLayoutManager.VERTICAL, false)
        }

    }

    fun setupSearchedRecyclerView(){

        searchedStudentsAdapter = SearchedStudentsAdapter()

        binding.searchRecyclerView.apply {
            adapter = searchedStudentsAdapter
            layoutManager = LinearLayoutManager(context,  LinearLayoutManager.VERTICAL, false)
        }

    }

    fun onStudentClick(){

        allStudentsAdapter.setOnStudentClick{ student ->
            val bundle = Bundle().apply {
                putInt("id", student.studentId)
                putString("name", student.name)
                putString("surename", student.surename)
                putString("email", student.email)
                putString("phone", student.phone)
                putString("birthday", student.birthday)
                putString("address", student.address)
                putString("gender", student.gender)
                putString("nationality", student.nationality)
                putString("citizenship", student.citizenship)
            }
            findNavController().navigate(R.id.action_searchFragment_to_profileFragment, bundle)
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
        binding.searchRecyclerView.isGone = false
        binding.searchingProgressBar.isGone = true
        binding.allRecyclerView.isGone = true
        binding.emptySearch.isGone = true
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}