package by.academy.android_hw_tomal


import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import by.academy.android_hw_tomal.hw1.Hw1Activity
import by.academy.android_hw_tomal.hw2.Hw2Activity

class MainActivity : AppCompatActivity() {
    private lateinit var btn_hw1: Button
    private lateinit var btn_hw2: Button

    companion object {
        private val ACTIVITY_HW1 = Hw1Activity::class.java
        private val ACTIVITY_HW2 = Hw2Activity::class.java
        private fun makeIntent(context: Context, classActivity: Class<*>): Intent {
            return Intent(context, classActivity)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_hw1 = findViewById(R.id.btn_hw1)
        btn_hw2 = findViewById(R.id.btn_hw2)
    }

    fun getActivityHW1(view: View) {
        startActivity(makeIntent(baseContext, ACTIVITY_HW1))
    }

    fun getActivityHW2(view: View) {
        startActivity(makeIntent(baseContext, ACTIVITY_HW2))
    }
}