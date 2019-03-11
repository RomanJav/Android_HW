package by.academy.hwTomal.hw4.customViews

import android.graphics.Color
import android.graphics.Paint

class PaintCollection{

    val clockPaint = Paint().apply {
        color = Color.parseColor("#15E07C")
        style = Paint.Style.STROKE
        strokeWidth = 10F
    }
    val dotPaint = Paint().apply {
        color = Color.parseColor("#15E07C")
        style = Paint.Style.FILL
        strokeWidth = 5F
    }
    val textPaint = Paint().apply {
        color = Color.parseColor("#15E07C")
        textSize = 50F
        textAlign = Paint.Align.CENTER
        style = Paint.Style.FILL
    }
    val hourLinePaint = Paint().apply {
        color = Color.parseColor("#D81B60")
        style = Paint.Style.STROKE
        strokeWidth = 10F
    }
    val minuteLinePaint = Paint().apply {
        color = Color.parseColor("#B10000")
        style = Paint.Style.STROKE
        strokeWidth = 10F
    }
    val secondLinePaint = Paint().apply {
        color = Color.parseColor("#00D80C")
        style = Paint.Style.STROKE
        strokeWidth = 10F
    }
    val piePartPaint = Paint().apply {
        style = Paint.Style.FILL
        strokeWidth = 0F
    }
    val pieLinePaint = Paint().apply {
        color = Color.DKGRAY
        style = Paint.Style.FILL
        strokeWidth = 8F
    }
}