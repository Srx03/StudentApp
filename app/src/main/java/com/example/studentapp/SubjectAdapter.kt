package com.example.studentapp


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.studentapp.databinding.ItemSubjectBinding
import com.example.studentapp.models.Subject


class SubjectAdapter(): RecyclerView.Adapter<SubjectAdapter.SubjectViewHolder>() {

    private var liveData: List<Subject>? = null
    var onItemClick: ((Subject) -> Unit)? = null


    @SuppressLint("NotifyDataSetChanged")
    fun setList(liveData: List<Subject>){
        this.liveData = liveData
        notifyDataSetChanged()
    }

    class SubjectViewHolder(val binding: ItemSubjectBinding): RecyclerView.ViewHolder(binding.root)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectViewHolder {
        return SubjectViewHolder(ItemSubjectBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: SubjectViewHolder, position: Int) {

        holder.binding.tvSubjectName.text = liveData!![position].subjectName

        holder.itemView.setOnLongClickListener {

            onItemClick!!.invoke(liveData!![1])
            true
        }

    }

    override fun getItemCount(): Int {
        return if(liveData == null) 0
          else  liveData!!.size
    }

    fun setOnSubjectClick(subject: (Subject) -> Unit) {
        onItemClick = subject
    }
}