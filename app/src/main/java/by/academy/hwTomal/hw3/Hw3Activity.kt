package by.academy.hwTomal.hw3

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import by.academy.android_hw_tomal.R
import com.squareup.picasso.Picasso

class Hw3Activity: AppCompatActivity() {
    private lateinit var image : ImageView
    private lateinit var imageURL : EditText
    private lateinit var btnSearch : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hw3)

        image=findViewById(R.id.image)
        imageURL=findViewById(R.id.textImageURL)
        btnSearch=findViewById(R.id.btnSearch)

        imageURL.append("https://cdn3.iconfinder.com/data/icons/avatars-15/64/_Ninja-2-512.png")
        btnSearch.setOnClickListener {
            Picasso.get().load(imageURL.text.toString()).placeholder(R.drawable.progress_animation).transform(CircleTransform()).into(image);
        }
    }
}