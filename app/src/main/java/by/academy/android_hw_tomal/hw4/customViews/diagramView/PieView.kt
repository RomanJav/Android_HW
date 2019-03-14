package by.academy.android_hw_tomal.hw4.customViews.diagramView

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import by.academy.android_hw_tomal.hw4.customViews.PaintCollection
import kotlin.random.Random

class PieView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var data = arrayListOf<Int>()
    private val rectF = RectF()
    private val paint = PaintCollection()
    private var startAngle: Float = 0F
    private var sumData: Float = 0F
    private var dataAngle = arrayListOf<Float>()
    private var canvasHeight: Float = 0F
    private var canvasWidth: Float = 0F
    private var pieRadius: Float = 0F

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (data.isNotEmpty()) {
            canvasHeight = height.toFloat()
            canvasWidth = width.toFloat()
            val minAttr = Math.min(canvasHeight, canvasWidth)
            pieRadius = minAttr / 2 - 120
            rectF.set(canvasWidth / 2 - pieRadius, canvasHeight / 2 - pieRadius, canvasWidth / 2 + pieRadius, canvasHeight / 2 + pieRadius)
            sumData = data.sum().toFloat()
            dataAngle = arrayListOf()
            makeAnglesFromData()
            for ((i, item) in dataAngle.withIndex()) {
                paint.piePartPaint.color = Color.parseColor("#${Random.nextInt(111111, 999999)}")
                canvas?.drawArc(rectF, startAngle, item, true, paint.piePartPaint)
                canvas?.rotate(item / 2 + startAngle, canvasWidth / 2, canvasHeight / 2)
                canvas?.drawLine(
                    canvasWidth / 2 + pieRadius,
                    canvasHeight / 2,
                    canvasWidth / 2 + pieRadius + 40,
                    canvasHeight / 2,
                    paint.pieLinePaint
                )
                canvas?.drawCircle(canvasWidth / 2 + pieRadius + 40, canvasHeight / 2, 13F, paint.pieLinePaint)
                canvas?.drawText(data[i].toString(), canvasWidth / 2 + pieRadius + 80, canvasHeight / 2, paint.textPaint)
                canvas?.rotate(-item / 2 - startAngle, canvasWidth / 2, canvasHeight / 2)
                startAngle += item
                canvas?.save()
            }
        }
    }

    private fun makeAnglesFromData() {
        for (item in data) {
            dataAngle.add((item / sumData) * 360)
        }
    }

    fun setData(items: ArrayList<Int>) {
        data = items
        invalidate()
    }
}