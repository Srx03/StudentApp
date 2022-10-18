package com.example.studentapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.studentapp.databinding.FragmentProfileBinding
import com.example.studentapp.databinding.FragmentSearchBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {


    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private lateinit var allStudentsAdapter: AllStudentsAdapter
    private val  viewModel: SearchViewModel by activityViewModels()

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

        setupRecyclerView()

    }


    fun setupRecyclerView(){
        allStudentsAdapter = AllStudentsAdapter()

        binding.allRecyclerView.apply {
            adapter = allStudentsAdapter
            layoutManager = LinearLayoutManager(context,  LinearLayoutManager.VERTICAL, false)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}