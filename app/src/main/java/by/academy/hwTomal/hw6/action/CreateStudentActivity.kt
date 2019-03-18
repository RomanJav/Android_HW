package by.academy.hwTomal.hw6.action

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import by.academy.android_hw_tomal.R
import by.academy.hwTomal.hw6.entity.Student
import by.academy.hwTomal.hw6.entity.StudentsListData
import kotlinx.android.synthetic.main.activity_add_student.*

class CreateStudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student)

        val studentId = StudentsListData.studentsList.lastIndex + 1

        btnSave.setOnClickListener {
            StudentsListData.addStudent(
                Student(
                    studentId,
                    editName.text.toString(),
                    (editAge.text.toString()).toInt(),
                    editPhoto.text.toString()
                )
            )
            StudentsListData.isChanged = true
            onBackPressed()
        }
    }
}