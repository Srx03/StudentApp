package com.example.studentapp.ui.subject


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.studentapp.data.entity.Student
import com.example.studentapp.data.entity.Test
import com.example.studentapp.databinding.ItemStudentSearchBinding
import com.example.studentapp.databinding.ItemStudentSubjectsAddBinding
import com.example.studentapp.databinding.ItemStudentSubjectsBinding
import com.example.studentapp.databinding.TestItemBinding
import com.example.studentapp.util.formatDate


class TestAdapter(): RecyclerView.Adapter<TestAdapter.TestViewHolder>() {

    private var tests: List<Test>? = null
    var onItemClick: ((Test) -> Unit)? = null


    @SuppressLint("NotifyDataSetChanged")
    fun setList(liveData: List<Test>){
        this.tests = liveData
        notifyDataSetChanged()
    }

    class TestViewHolder(val binding: TestItemBinding): RecyclerView.ViewHolder(binding.root)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestViewHolder{
        return TestViewHolder(TestItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: TestViewHolder, position: Int) {

        holder.binding.tvTestName.text = tests!![position].name
        holder.binding.tvDate.text = tests!![position].date
        holder.binding.tvTime.text = tests!![position].time

        holder.itemView.setOnLongClickListener {
            onItemClick!!.invoke(tests!![position])
            true
        }

    }

    override fun getItemCount(): Int {
        return if(tests == null) 0
          else tests!!.size
    }

    fun setOnTestClick(test: (Test) -> Unit) {
        onItemClick = test
    }
}