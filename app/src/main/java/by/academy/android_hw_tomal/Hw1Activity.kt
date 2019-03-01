package by.academy.android_hw_tomal

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.view.View
import android.widget.Button
import android.widget.TextView

class Hw1Activity : AppCompatActivity() {
    private lateinit var text1: TextView
    private lateinit var text2: TextView
    private lateinit var button: Button
    private var buttonColor: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text1 = findViewById(R.id.text1)
        text2 = findViewById(R.id.text2)
        button = findViewById(R.id.button)
        text1.text = "Hello there!"
        text2.text = "General Kenobi!"

        text1.setOnClickListener {
            swapTextOnClick()
        }
        text2.setOnClickListener {
            swapTextOnClick()
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun clickMe(view: View) {
        val bufferText = text1.text
        text1.text = text2.text
        text2.text = bufferText
        if (buttonColor == 0) {
            buttonColor++
            button.setBackgroundColor(resources.getColor(R.color.ButtonTwo, theme))
        } else {
            buttonColor--
            button.setBackgroundColor(resources.getColor(R.color.ButtonOne, theme))
        }
    }

    fun swapTextOnClick() {
        val bufferText = text1.text
        val bufferTextColor = text1.currentTextColor
        val bufferBackgroundColor = text1.background
        text1.text = text2.text
        text1.setTextColor(text2.currentTextColor)
        text1.background = text2.background
        text2.text = bufferText
        text2.setTextColor(bufferTextColor)
        text2.background = bufferBackgroundColor

    }
}