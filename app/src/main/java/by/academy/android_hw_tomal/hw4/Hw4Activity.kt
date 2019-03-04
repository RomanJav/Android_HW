package by.academy.android_hw_tomal.hw4

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import by.academy.android_hw_tomal.R

class Hw4Activity: AppCompatActivity() {
    private lateinit var owlImage : ImageView
    private lateinit var frameAnimation: AnimationDrawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hw4)

        owlImage=findViewById(R.id.owl_image)
        frameAnimation=owlImage.background as AnimationDrawable
        owlImage.setOnClickListener{
            startAnimation()
        }
    }

    private fun startAnimation(){
        frameAnimation.start()
        if (frameAnimation.isRunning){
            frameAnimation.stop()
            frameAnimation.start()
        }
    }
}