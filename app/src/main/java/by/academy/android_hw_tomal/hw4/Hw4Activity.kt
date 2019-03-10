package by.academy.android_hw_tomal.hw4

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import android.widget.RadioGroup
import by.academy.android_hw_tomal.R
import by.academy.android_hw_tomal.hw4.custom_views.clockView.Clock
import by.academy.android_hw_tomal.hw4.custom_views.diagramView.Pie

class Hw4Activity : AppCompatActivity() {
    private lateinit var owlImage: ImageView
    private lateinit var frameAnimation: AnimationDrawable
    private lateinit var clock: Clock
    private lateinit var pie: Pie
    private var pieData= arrayListOf(2,5,6,8,5,3,2)
    private lateinit var radioViews: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hw4)

        owlImage = findViewById(R.id.owl_image)
        owlImage.visibility = View.INVISIBLE
        clock = findViewById(R.id.clock)
        clock.visibility = View.INVISIBLE
        pie = findViewById(R.id.pie)
        pie.setData(pieData)
        pie.visibility = View.INVISIBLE
        radioViews = findViewById(R.id.radioViews)
        radioViews.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.owl_rb -> {
                    owlImage.visibility = View.VISIBLE
                    clock.visibility = View.INVISIBLE
                    pie.visibility = View.INVISIBLE
                }
                R.id.clock_rb -> {
                    owlImage.visibility = View.INVISIBLE
                    clock.visibility = View.VISIBLE
                    pie.visibility = View.INVISIBLE
                }
                R.id.pie_rb -> {
                    owlImage.visibility = View.INVISIBLE
                    clock.visibility = View.INVISIBLE
                    pie.visibility = View.VISIBLE
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