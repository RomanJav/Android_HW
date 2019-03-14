package by.academy.android_hw_tomal.hw4.customViews.clockView

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import java.util.*
import by.academy.android_hw_tomal.hw4.customViews.PaintCollection

class ClockView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val rectF = RectF()
    private val paint = PaintCollection()
    private var canvasHeight: Float = 0F
    private var canvasWidth: Float = 0F
    private var clockRadius: Float = 0F
    private var handTruncation: Float = 0F
    private var hourHandTruncation: Float = 0F


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvasHeight = height.toFloat()
        canvasWidth = width.toFloat()
        val minAttr = Math.min(canvasHeight, canvasWidth)
        clockRadius = minAttr / 2 - 80
        handTruncation = minAttr / 20
        hourHandTruncation = minAttr / 15

        /* Circle with hour lines*/
        rectF.set(canvasWidth / 2 - clockRadius, canvasHeight / 2 - clockRadius, canvasWidth / 2 + clockRadius, canvasHeight / 2 + clockRadius)
        canvas?.drawCircle(canvasWidth / 2, canvasHeight / 2, 15F, paint.dotPaint)
        for (i in 1..12) {
            canvas?.drawLine(canvasWidth / 2 + clockRadius, canvasHeight / 2, canvasWidth / 2 + clockRadius - 40, canvasHeight / 2, paint.clockPaint)
            canvas?.drawArc(rectF, 0F, 30F, false, paint.clockPaint)
            canvas?.rotate(30F, canvasWidth / 2, canvasHeight / 2)
        }
        canvas?.save()
        /* Hour humbers*/
        canvas?.drawText("3", canvasWidth / 2 + clockRadius + 40, canvasHeight / 2 + 20, paint.textPaint)
        canvas?.drawText("6", canvasWidth / 2, canvasHeight / 2 + clockRadius + 60, paint.textPaint)
        canvas?.drawText("9", canvasWidth / 2 - clockRadius - 50, canvasHeight / 2 + 20, paint.textPaint)
        canvas?.drawText("12", canvasWidth / 2, canvasHeight / 2 - clockRadius - 30, paint.textPaint)

        val calendar = Calendar.getInstance()
        var hour = calendar.get(Calendar.HOUR_OF_DAY)
        hour = if (hour > 12) hour - 12 else hour

        drawHandLine(canvas, ((hour + calendar.get(Calendar.MINUTE) / 60) * 5f).toDouble(), true, false) /* Hour line*/
        drawHandLine(canvas, calendar.get(Calendar.MINUTE).toDouble(), false, false) /* Minute line*/
        drawHandLine(canvas, calendar.get(Calendar.SECOND).toDouble(), false, true) /* Second line*/
        postInvalidateDelayed(500)
        invalidate()
    }

    private fun drawHandLine(canvas: Canvas?, moment: Double, isHour: Boolean, isSecond: Boolean) {
        var linePaint = paint.minuteLinePaint
        val angle = Math.PI * moment / 30 - Math.PI / 2
        val handRadius = if (isHour) clockRadius - handTruncation - hourHandTruncation else clockRadius - handTruncation
        if (isHour) linePaint = paint.hourLinePaint
        if (isSecond) linePaint = paint.secondLinePaint
        canvas?.drawLine(
            canvasWidth / 2,
            canvasHeight / 2,
            canvasWidth / 2 + Math.cos(angle).toFloat() * handRadius,
            canvasHeight / 2 + Math.sin(angle).toFloat() * handRadius,
            linePaint
        )
    }

}