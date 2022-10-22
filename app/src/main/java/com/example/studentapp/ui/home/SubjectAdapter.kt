package com.example.studentapp.ui.home


import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.studentapp.databinding.ItemSubjectBinding
import com.example.studentapp.data.entity.Subject


class SubjectAdapter(): RecyclerView.Adapter<SubjectAdapter.SubjectViewHolder>() {

    private var allSubjects: List<Subject>? = null
    var onItemClick: ((Subject) -> Unit)? = null


    @SuppressLint("NotifyDataSetChanged")
    fun setList(liveData: List<Subject>){
        this.allSubjects = liveData
        notifyDataSetChanged()
    }

    class SubjectViewHolder(val binding: ItemSubjectBinding): RecyclerView.ViewHolder(binding.root)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectViewHolder {
        return SubjectViewHolder(ItemSubjectBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: SubjectViewHolder, position: Int) {

        holder.binding.tvSubjectName.text = allSubjects!![position].subjectName

        holder.itemView.setOnLongClickListener {
            Log.d("testic",allSubjects!![position].toString())
            onItemClick!!.invoke(allSubjects!![position])
            true
        }

    }

    override fun getItemCount(): Int {
        return if(allSubjects == null) 0
          else  allSubjects!!.size
    }

    fun setOnSubjectClick(subject: (Subject) -> Unit) {
        onItemClick = subject
    }
}