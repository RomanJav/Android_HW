package by.academy.hwTomal.hw7.fragment

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.academy.android_hw_tomal.R
import by.academy.hwTomal.hw7.entity.Student
import by.academy.hwTomal.hw7.entity.StudentsListData
import kotlinx.android.synthetic.main.activity_edit_student.*

class StudentEditFragment : Fragment() {
    lateinit var attachActivity: Activity
    lateinit var student: Student

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.activity_edit_student, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnSave.setOnClickListener {
            StudentsListData.editStudent(
                Student(
                    student.id,
                    editName.text.toString(),
                    (editAge.text.toString()).toInt(),
                    editPhoto.text.toString()
                )
            )
            StudentsListData.isChanged = true
            if (!StudentsListData.isEditInActivity)
                activity?.onBackPressed()
        }
        btnDelete.setOnClickListener {
            StudentsListData.deleteStudent(student.id)
            StudentsListData.isChanged = true
            if (!StudentsListData.isEditInActivity)
                activity?.onBackPressed()
        }

    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        attachActivity = context as Activity
    }

    fun showEdit(id: Int) {
        for (student in StudentsListData.studentsList) {
            if (student.id == id) {
                this.student = student
                editPhoto.setText(student.photo)
                editName.setText(student.fullName)
                editAge.setText(student.age.toString())
            }
        }
    }
}
