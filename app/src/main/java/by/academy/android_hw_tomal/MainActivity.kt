package by.academy.android_hw_tomal

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var btn_hw1 :Button
    private lateinit var btn_hw2 :Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_hw1=findViewById(R.id.btn_hw1)
        btn_hw2=findViewById(R.id.btn_hw2)
    }

    fun getHomeWork1(view: View) {
        val intent = Intent(this, Hw1Activity::class.java)
        startActivity(intent)
    }
}