package by.academy.hwTomal


import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import by.academy.android_hw_tomal.R
import by.academy.hwTomal.hw1.Hw1Activity
import by.academy.hwTomal.hw2.Hw2Activity
import by.academy.hwTomal.hw3.Hw3Activity
import by.academy.hwTomal.hw4.Hw4Activity

class MainActivity : AppCompatActivity() {
    private lateinit var btnHw1: Button
    private lateinit var btnHw2: Button
    private lateinit var btnHw3: Button
    private lateinit var btnHw4: Button

    companion object {
        private val ACTIVITY_HW1 = Hw1Activity::class.java
        private val ACTIVITY_HW2 = Hw2Activity::class.java
        private val ACTIVITY_HW3 = Hw3Activity::class.java
        private val ACTIVITY_HW4 = Hw4Activity::class.java
        private fun createIntent(context: Context, classActivity: Class<*>): Intent {
            return Intent(context, classActivity)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnHw1 = findViewById(R.id.btn_hw1)
        btnHw2 = findViewById(R.id.btn_hw2)
        btnHw3 = findViewById(R.id.btn_hw3)
        btnHw4 = findViewById(R.id.btn_hw4)
    }

    fun startActivityHW1(view: View) {
        startActivity(
            createIntent(
                baseContext,
                ACTIVITY_HW1
            )
        )
        overridePendingTransition(
            R.anim.animation_activity_up,
            R.anim.animation_activity_down
        )
    }

    fun startActivityHW2(view: View) {
        startActivity(
            createIntent(
                baseContext,
                ACTIVITY_HW2
            )
        )
        overridePendingTransition(
            R.anim.animation_activity_up,
            R.anim.animation_activity_down
        )
    }

    fun startActivityHW3(view: View) {
        startActivity(
            createIntent(
                baseContext,
                ACTIVITY_HW3
            )
        )
        overridePendingTransition(
            R.anim.animation_activity_up,
            R.anim.animation_activity_down
        )
    }

    fun startActivityHW4(view: View) {
        startActivity(
            createIntent(
                baseContext,
                ACTIVITY_HW4
            )
        )
        overridePendingTransition(
            R.anim.animation_activity_up,
            R.anim.animation_activity_down
        )
    }
}