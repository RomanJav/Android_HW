package by.academy.hwTomal.hw6.action

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import by.academy.android_hw_tomal.R
import by.academy.hwTomal.hw6.entity.Student
import by.academy.hwTomal.hw6.entity.StudentsListData
import kotlinx.android.synthetic.main.activity_edit_student.*

class EditStudentActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_student)

        val studentId = intent.getStringExtra("ID")
        editPhoto.setText(intent.getStringExtra("PHOTO"))
        editName.setText(intent.getStringExtra("NAME"))
        editAge.setText(intent.getStringExtra("AGE"))

        btnSave.setOnClickListener{
            StudentsListData.editStudent(Student(studentId.toInt(), editName.text.toString(), (editAge.text.toString()).toInt(), editPhoto.text.toString()))
            StudentsListData.isChanged = true
            onBackPressed()
        }
        btnDelete.setOnClickListener{
            StudentsListData.deleteStudent(studentId.toInt())
            onBackPressed()
            StudentsListData.isChanged = true
        }
    }
}