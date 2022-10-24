package com.example.studentapp.ui.subject


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.studentapp.data.entity.Student
import com.example.studentapp.databinding.ItemStudentSearchBinding
import com.example.studentapp.databinding.ItemStudentSubjectsAddBinding
import com.example.studentapp.databinding.ItemStudentSubjectsBinding
import com.example.studentapp.util.formatDate


class StudentsToAddAdapter(): RecyclerView.Adapter<StudentsToAddAdapter.StudentsToAddViewHolder>() {

    private var allStudent: List<Student>? = null
    var onItemClick: ((Student) -> Unit)? = null


    @SuppressLint("NotifyDataSetChanged")
    fun setList(liveData: List<Student>){
        this.allStudent = liveData
        notifyDataSetChanged()
    }

    class StudentsToAddViewHolder(val binding: ItemStudentSubjectsAddBinding): RecyclerView.ViewHolder(binding.root)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentsToAddViewHolder {
        return StudentsToAddViewHolder(ItemStudentSubjectsAddBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: StudentsToAddViewHolder, position: Int) {

        holder.binding.tvStudentName.text = allStudent!![position].name + " " + allStudent!![position].surename
        holder.binding.tvEmail.text = allStudent!![position].email
        holder.binding.tvBirthday.formatDate(allStudent!![position].birthday)

        holder.binding.btnAdd.setOnClickListener {
            onItemClick!!.invoke(allStudent!![position])
        }

    }

    override fun getItemCount(): Int {
        return if(allStudent == null) 0
          else allStudent!!.size
    }

    fun setOnStudentAddClick(student: (Student) -> Unit) {
        onItemClick = student
    }
}