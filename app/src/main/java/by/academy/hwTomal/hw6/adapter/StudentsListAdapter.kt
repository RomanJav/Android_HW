package by.academy.hwTomal.hw6.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import by.academy.android_hw_tomal.R
import by.academy.hwTomal.hw6.entity.StudentsListData
import android.content.Intent
import by.academy.hwTomal.hw6.action.EditStudentActivity


class StudentsListAdapter : RecyclerView.Adapter<StudentsListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, value: Int): StudentsListViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.student_card_item, viewGroup, false)
        val holder = StudentsListViewHolder(view)
        view.setOnClickListener {
            val intent = Intent(viewGroup.context, EditStudentActivity::class.java)
            intent.putExtra("ID", StudentsListData.studentsList[holder.adapterPosition].objectId)
            it.context.startActivity(intent)
        }
        return holder
    }


    override fun getItemCount(): Int {
        return StudentsListData.studentsList.size
    }

    override fun onBindViewHolder(studentsList: StudentsListViewHolder, index: Int) {
        studentsList.bind(StudentsListData.studentsList[index])
    }


}