package by.academy.hwTomal.hw7.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import by.academy.hwTomal.hw7.entity.Student
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.student_card_item.view.*


class StudentsListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(student: Student) {
        Picasso.get().load(student.photo).transform(CircleTransform()).into(itemView.student_photo)

        itemView.student_name.text = student.fullName

        itemView.student_age.text = student.age.toString()
    }

}