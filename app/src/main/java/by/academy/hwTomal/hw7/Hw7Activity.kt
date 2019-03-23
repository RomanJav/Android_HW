package by.academy.hwTomal.hw7



import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import by.academy.android_hw_tomal.R
import by.academy.hwTomal.hw7.entity.StudentsListData
import by.academy.hwTomal.hw7.fragment.StudentEditFragment
import by.academy.hwTomal.hw7.fragment.StudentListFragment
import kotlinx.android.synthetic.main.fragment_edit_student.*


class Hw7Activity : AppCompatActivity(), StudentListFragment.Updater {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hw7)

        StudentsListData.isEditInActivity = studentEditFragment?.isInLayout ?: false
    }

    override fun update(id: Int) {
        if(StudentsListData.isEditInActivity){
            val fragment = supportFragmentManager.findFragmentById(R.id.studentEditFragment) as StudentEditFragment
            fragment.showEdit(id)
        }
    }
}