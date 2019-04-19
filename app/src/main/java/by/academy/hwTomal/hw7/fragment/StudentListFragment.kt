package by.academy.hwTomal.hw7.fragment

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.academy.android_hw_tomal.R
import by.academy.hwTomal.hw7.action.CreateStudentActivity
import by.academy.hwTomal.hw7.adapter.StudentsListAdapter
import by.academy.hwTomal.hw7.entity.StudentsListData
import kotlinx.android.synthetic.main.activity_list_student.*
import by.academy.hwTomal.hw7.entity.Student


class StudentListFragment : Fragment() {
    private val studentAdapter = StudentsListAdapter()
    lateinit var attachActivity: Activity

    companion object {
        private val CREATE_STUDENT = CreateStudentActivity::class.java
        private fun createIntent(context: Context, classActivity: Class<*>): Intent {
            return Intent(context, classActivity)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.activity_list_student, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val linearLayoutManager = LinearLayoutManager(context)
        studentRecyclerView.layoutManager = linearLayoutManager
        studentRecyclerView.adapter = studentAdapter
        studentAdapter.setOnItemClickListener(onItemClickListener)
        createStudentButton.setOnClickListener {
            activity?.let {
                startActivity(
                    StudentListFragment.createIntent(
                        it,
                        StudentListFragment.CREATE_STUDENT
                    )
                )
            }
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        attachActivity = context as Activity
    }

    override fun onPause() {
        if (StudentsListData.isChanged) {
            studentAdapter.notifyDataSetChanged()
            StudentsListData.isChanged = false
        }
        super.onPause()
    }

    override fun onResume() {
        if (StudentsListData.isChanged) {
            studentAdapter.notifyDataSetChanged()
            StudentsListData.isChanged = false
        }
        super.onResume()
    }

    private val onItemClickListener = object : StudentsListAdapter.OnItemClickListener {
        override fun onClick(item: Student) {
            (attachActivity as Updater).update(item.id)
            if (StudentsListData.isChanged) {
                studentAdapter.notifyDataSetChanged()
                StudentsListData.isChanged = false
            }
        }
    }

    interface Updater {
        fun update(id: Int)
    }
}