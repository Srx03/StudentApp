package com.example.studentapp


import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.studentapp.data.entity.Student
import com.example.studentapp.databinding.ItemSubjectBinding
import com.example.studentapp.data.entity.Subject
import com.example.studentapp.databinding.ItemStudentSearchBinding
import com.example.studentapp.util.formatDate


class AllStudentsAdapter(): RecyclerView.Adapter<AllStudentsAdapter.AllStudentsViewHolder>() {

    private var allStudent: List<Student>? = null
    var onItemClick: ((Student) -> Unit)? = null


    @SuppressLint("NotifyDataSetChanged")
    fun setList(liveData: List<Student>){
        this.allStudent = liveData
        notifyDataSetChanged()
    }

    class AllStudentsViewHolder(val binding: ItemStudentSearchBinding): RecyclerView.ViewHolder(binding.root)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllStudentsViewHolder {
        return AllStudentsViewHolder(ItemStudentSearchBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: AllStudentsViewHolder, position: Int) {

        holder.binding.tvStudentName.text = allStudent!![position].name + " " + allStudent!![position].surename
        holder.binding.tvEmail.text = allStudent!![position].email
        holder.binding.tvBirthday.formatDate(allStudent!![position].birthday)

        holder.itemView.setOnLongClickListener {
            onItemClick!!.invoke(allStudent!![position])
            true
        }

    }

    override fun getItemCount(): Int {
        return if(allStudent == null) 0
          else allStudent!!.size
    }

    fun setOnStudentClick(student: (Student) -> Unit) {
        onItemClick = student
    }
}