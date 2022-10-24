package com.example.studentapp.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.studentapp.R
import com.example.studentapp.databinding.FragmentHomeBinding
import com.example.studentapp.data.entity.Subject
import com.example.studentapp.util.showSnackBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {


    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var subjectAdapter: SubjectAdapter
    private val  viewModel: HomeViewModel by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        setupRecyclerView()

        binding.btnAddSubject.setOnClickListener {

            if (binding.nameEditText.text.isNullOrBlank()) {

                showSnackBar(message = "Please add subject name")

            } else {

                val subject = Subject(
                    subjectId = 0,
                    binding.nameEditText.text.toString()
                )
                viewModel.addSubject(subject)

                Log.d("radiiii",subject.toString())
            }
        }


        viewModel.getAllSubjects().observe(viewLifecycleOwner){

            subjectAdapter.setList(it)

            Log.d("subjectt",it.toString())


        }

        subjectAdapter.setOnHoldSubjectClick {
            viewModel.deleteSubject(it.subjectId)
        }

        subjectAdapter.setOnSubjectClick {
            val bundle = Bundle().apply{
                putInt("subjectId", it.subjectId)
                putString("subjectName", it.subjectName)
            }
            findNavController().navigate(R.id.action_homeFragment_to_subjectFragment, bundle)
        }



    }

    fun setupRecyclerView(){
        subjectAdapter = SubjectAdapter()

        binding.subjectRecyclerView.apply {
            adapter = subjectAdapter
            layoutManager = LinearLayoutManager(context,  LinearLayoutManager.VERTICAL, false)
        }

    }




    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}