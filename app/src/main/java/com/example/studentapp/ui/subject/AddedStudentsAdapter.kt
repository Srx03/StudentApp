package com.example.studentapp.ui.subject


import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.studentapp.data.entity.Student
import com.example.studentapp.data.entity.relations.SubjectWithStudents
import com.example.studentapp.databinding.ItemStudentSearchBinding
import com.example.studentapp.databinding.ItemStudentSubjectsAddBinding
import com.example.studentapp.databinding.ItemStudentSubjectsBinding
import com.example.studentapp.util.formatDate


class AddedStudentsAdapter(): RecyclerView.Adapter<AddedStudentsAdapter. AddedStudentsViewHolder>() {

    private var allStudent: List<SubjectWithStudents>? = null
    var onItemClick: ((SubjectWithStudents) -> Unit)? = null


    @SuppressLint("NotifyDataSetChanged")
    fun setList(liveData: List<SubjectWithStudents>){
        this.allStudent = liveData
        notifyDataSetChanged()
    }

    class  AddedStudentsViewHolder(val binding: ItemStudentSubjectsBinding): RecyclerView.ViewHolder(binding.root)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddedStudentsViewHolder {
        return AddedStudentsViewHolder(ItemStudentSubjectsBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: AddedStudentsViewHolder, position: Int) {

        holder.binding.tvStudentName.text = allStudent!![position].students[position].name + " " + allStudent!![position].students[position].surename
        holder.binding.tvEmail.text = allStudent!![position].students[position].email
        holder.binding.tvBirthday.formatDate(allStudent!![position].students[position].birthday)
        Log.d("final",allStudent!![position].students[position].name)

        holder.binding.btnRemove.setOnClickListener {
            onItemClick!!.invoke(allStudent!![position])
        }

    }

    override fun getItemCount(): Int {
        return if(allStudent == null) 0
          else allStudent!!.size
    }

    fun setOnStudentDeleteClick(student: (SubjectWithStudents) -> Unit) {
        onItemClick = student
    }
}