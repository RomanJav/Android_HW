package by.academy.hwTomal.hw7.action

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import by.academy.android_hw_tomal.R
import by.academy.hwTomal.hw7.fragment.StudentEditFragment

class EditStudentActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_edit_student)

        val fragment = supportFragmentManager.findFragmentById(R.id.studentEditFragment) as StudentEditFragment
        fragment.showEdit(intent.getStringExtra("ID").toInt())
    }
}