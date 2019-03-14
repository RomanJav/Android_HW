package by.academy.android_hw_tomal.hw4.custom_views.diagramView

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import by.academy.android_hw_tomal.hw4.custom_views.PaintCollection
import kotlin.random.Random

class Pie @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var data = arrayListOf<Int>()
    private val rectF = RectF()
    private val paint = PaintCollection()
    private var startAngle: Float = 0F
    private var sumData: Float = 0F
    private var dataAngle = arrayListOf<Float>()
    private var cHeight: Float = 0F
    private var cWidth: Float = 0F
    private var cRadius: Float = 0F

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (data.isNotEmpty()) {
            cHeight = height.toFloat()
            cWidth = width.toFloat()
            val minAttr = Math.min(cHeight, cWidth)
            cRadius = minAttr / 2 - 120
            rectF.set(cWidth / 2 - cRadius, cHeight / 2 - cRadius, cWidth / 2 + cRadius, cHeight / 2 + cRadius)
            sumData = data.sum().toFloat()
            makeAnglesFromData()
            for ((i, item) in dataAngle.withIndex()) {
                paint.piePartPaint.color = Color.parseColor("#${Random.nextInt(111111, 999999)}")
                canvas?.drawArc(rectF, startAngle, item, true, paint.piePartPaint)
                canvas?.rotate(item / 2 + startAngle, cWidth / 2, cHeight / 2)
                canvas?.drawLine(
                    cWidth / 2 + cRadius,
                    cHeight / 2,
                    cWidth / 2 + cRadius + 40,
                    cHeight / 2,
                    paint.pieLinePaint
                )
                canvas?.drawCircle(cWidth / 2 + cRadius + 40, cHeight / 2, 13F, paint.pieLinePaint)
                canvas?.drawText(data[i].toString(), cWidth / 2 + cRadius + 80, cHeight / 2, paint.textPaint)
                canvas?.rotate(-item / 2 - startAngle, cWidth / 2, cHeight / 2)
                startAngle += item
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