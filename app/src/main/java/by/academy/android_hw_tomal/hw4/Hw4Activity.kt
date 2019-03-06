package by.academy.android_hw_tomal.hw4

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import android.widget.RadioGroup
import by.academy.android_hw_tomal.R
import by.academy.android_hw_tomal.hw4.custom_views.clockView.Clock

class Hw4Activity : AppCompatActivity() {
    private lateinit var owlImage: ImageView
    private lateinit var frameAnimation: AnimationDrawable
    private lateinit var clock: Clock
    private lateinit var radioViews: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hw4)

        owlImage = findViewById(R.id.owl_image)
        owlImage.visibility = View.INVISIBLE
        clock = findViewById(R.id.clock)
        clock.visibility = View.INVISIBLE
        radioViews = findViewById(R.id.radioViews)
        radioViews?.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId.equals(R.id.owl_rb)){
                owlImage.visibility = View.VISIBLE
                clock.visibility = View.INVISIBLE
            }
            else if (checkedId.equals(R.id.clock_rb)){
                clock.visibility = View.VISIBLE
                owlImage.visibility = View.INVISIBLE
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