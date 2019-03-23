package by.academy.hwTomal.hw7.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import by.academy.android_hw_tomal.R
import android.content.Intent
import android.view.View
import by.academy.hwTomal.hw7.entity.Student
import by.academy.hwTomal.hw7.action.EditStudentActivity
import by.academy.hwTomal.hw7.entity.StudentsListData


class StudentsListAdapter : RecyclerView.Adapter<StudentsListViewHolder>() {

    private var onItemClickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(viewGroup: ViewGroup, value: Int): StudentsListViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.student_card_item, viewGroup, false)
        val holder = StudentsListViewHolder(view)
        view.setOnClickListener {
            if (onItemClickListener!=null && StudentsListData.isEditInActivity) {
                onItemClickListener!!.onClick(StudentsListData.studentsList[holder.adapterPosition])
            } else {
                val intent = Intent(viewGroup.context, EditStudentActivity::class.java)
                intent.putExtra("ID", StudentsListData.studentsList[holder.adapterPosition].id.toString())
                intent.putExtra("NAME", StudentsListData.studentsList[holder.adapterPosition].fullName)
                intent.putExtra("PHOTO", StudentsListData.studentsList[holder.adapterPosition].photo)
                intent.putExtra("AGE", StudentsListData.studentsList[holder.adapterPosition].age.toString())
                intent.putExtra("HOLDER", holder.adapterPosition)
                it.context.startActivity(intent)
            }
        }
        return holder
    }

    override fun getItemCount(): Int {
        return StudentsListData.studentsList.size
    }

    override fun onBindViewHolder(studentsList: StudentsListViewHolder, index: Int) {
        studentsList.bind(StudentsListData.studentsList[index])
    }

    interface OnItemClickListener {
        fun onClick(item: Student)
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }

}