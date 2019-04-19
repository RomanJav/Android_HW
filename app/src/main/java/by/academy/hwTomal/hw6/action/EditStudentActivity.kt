package by.academy.hwTomal.hw6.action

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import by.academy.android_hw_tomal.R
import by.academy.hwTomal.hw6.entity.Student
import by.academy.hwTomal.hw6.entity.StudentsListData
import by.academy.hwTomal.hw6.entity.StudentsListData.studentsList
import kotlinx.android.synthetic.main.activity_edit_student.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class EditStudentActivity : AppCompatActivity() {

    lateinit var student: Student

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_student)

        val studentId = intent.getStringExtra("ID")
        for (studentIt in studentsList) {
            if (studentIt.objectId == studentId) {
                student = studentIt
                break
            }
        }
        editPhoto.setText(student.photo)
        editName.setText(student.fullName)
        editAge.setText(student.age.toString())

        btnSave.setOnClickListener {
            GlobalScope.launch(context = Dispatchers.Main) {
                withContext(Dispatchers.Default) {
                    StudentsListData.editStudent(
                        Student(
                            studentId,
                            editName.text.toString(),
                            (editAge.text.toString()).toInt(),
                            editPhoto.text.toString()
                        )
                    )
                }
                StudentsListData.isChanged = true
                onBackPressed()
            }
        }
        btnDelete.setOnClickListener {
            GlobalScope.launch(context = Dispatchers.Main) {
                withContext(Dispatchers.Default) {
                    StudentsListData.deleteStudent(student.objectId)
                }
                StudentsListData.isChanged = true
                onBackPressed()
            }
        }
    }
}