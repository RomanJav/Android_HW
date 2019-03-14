package by.academy.android_hw_tomal.hw4

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import by.academy.android_hw_tomal.R
import kotlinx.android.synthetic.main.activity_hw4.*

class Hw4Activity : AppCompatActivity() {
    private lateinit var frameAnimation: AnimationDrawable
    private var pieData= arrayListOf(2,5,6,8,5,3,2)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hw4)

        owlImage.visibility = View.INVISIBLE
        clockView.visibility = View.INVISIBLE
        pieView.setData(pieData)
        pieView.visibility = View.INVISIBLE
        radioViews.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.owl_rb -> {
                    owlImage.visibility = View.VISIBLE
                    clockView.visibility = View.INVISIBLE
                    pieView.visibility = View.INVISIBLE
                }
                R.id.clock_rb -> {
                    owlImage.visibility = View.INVISIBLE
                    clockView.visibility = View.VISIBLE
                    pieView.visibility = View.INVISIBLE
                }
                R.id.pie_rb -> {
                    owlImage.visibility = View.INVISIBLE
                    clockView.visibility = View.INVISIBLE
                    pieView.visibility = View.VISIBLE
                }
            }
        }
        frameAnimation = owlImage.background as AnimationDrawable
        owlImage.setOnClickListener {
            startAnimation()
        }
    }

    private fun startAnimation() {
        frameAnimation.start()
        if (frameAnimation.isRunning) {
            frameAnimation.stop()
            frameAnimation.start()
        }
    }
}