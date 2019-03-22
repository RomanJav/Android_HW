package by.academy.hwTomal.hw7

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import by.academy.android_hw_tomal.R
import by.academy.hwTomal.hw6.action.CreateStudentActivity
import by.academy.hwTomal.hw6.adapter.StudentsListAdapter
import by.academy.hwTomal.hw6.entity.StudentsListData
import kotlinx.android.synthetic.main.activity_hw6.*

class Hw7Activity : AppCompatActivity() {
    private val studentAdapter = StudentsListAdapter()

    companion object {
        private val CREATE_STUDENT = CreateStudentActivity::class.java
        private fun createIntent(context: Context, classActivity: Class<*>): Intent {
            return Intent(context, classActivity)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hw6)

        val linearLayoutManager = LinearLayoutManager(this)
        studentRecyclerView.setHasFixedSize(true)
        studentRecyclerView.layoutManager = linearLayoutManager
        studentRecyclerView.adapter = studentAdapter

        createStudentButton.setOnClickListener {
            startActivity(
                createIntent(
                    baseContext,
                    CREATE_STUDENT
                )
            )
        }
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
}