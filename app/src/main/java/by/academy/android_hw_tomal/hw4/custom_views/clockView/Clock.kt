package by.academy.android_hw_tomal.hw4.custom_views.clockView

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import java.util.*
import by.academy.android_hw_tomal.hw4.custom_views.PaintCollection

class Clock @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val rectF = RectF()
    private val paint = PaintCollection()
    private var cHeight: Float = 0F
    private var cWidth: Float = 0F
    private var cRadius: Float = 0F
    private var handTruncation: Float = 0F
    private var hourHandTruncation: Float = 0F


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        cHeight = height.toFloat()
        cWidth = width.toFloat()
        val minAttr = Math.min(cHeight, cWidth)
        cRadius = minAttr / 2 - 80
        handTruncation = minAttr / 20
        hourHandTruncation = minAttr / 15

        /* Circle with hour lines*/
        rectF.set(cWidth / 2 - cRadius, cHeight / 2 - cRadius, cWidth / 2 + cRadius, cHeight / 2 + cRadius)
        canvas?.drawCircle(cWidth / 2, cHeight / 2, 15F, paint.dotPaint)
        for (i in 1..12) {
            canvas?.drawLine(cWidth / 2 + cRadius, cHeight / 2, cWidth / 2 + cRadius - 40, cHeight / 2, paint.clockPaint)
            canvas?.drawArc(rectF, 0F, 30F, false, paint.clockPaint)
            canvas?.rotate(30F, cWidth / 2, cHeight / 2)
        }
        canvas?.save()
        /* Hour humbers*/
        canvas?.drawText("3", cWidth / 2 + cRadius + 40, cHeight / 2 + 20, paint.textPaint)
        canvas?.drawText("6", cWidth / 2, cHeight / 2 + cRadius + 60, paint.textPaint)
        canvas?.drawText("9", cWidth / 2 - cRadius - 50, cHeight / 2 + 20, paint.textPaint)
        canvas?.drawText("12", cWidth / 2, cHeight / 2 - cRadius - 30, paint.textPaint)

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
        val handRadius = if (isHour) cRadius - handTruncation - hourHandTruncation else cRadius - handTruncation
        if (isHour) linePaint = paint.hourLinePaint
        if (isSecond) linePaint = paint.secondLinePaint
        canvas?.drawLine(
            cWidth / 2,
            cHeight / 2,
            cWidth / 2 + Math.cos(angle).toFloat() * handRadius,
            cHeight / 2 + Math.sin(angle).toFloat() * handRadius,
            linePaint
        )
    }

}