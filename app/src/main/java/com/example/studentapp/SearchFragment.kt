package com.example.studentapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
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
        onStudentClick()

    }


    fun setupRecyclerView(){
        allStudentsAdapter = AllStudentsAdapter()

        binding.allRecyclerView.apply {
            adapter = allStudentsAdapter
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}