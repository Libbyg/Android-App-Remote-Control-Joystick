package com.example.joystick.views

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.os.Build
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.SeekBar
import androidx.annotation.RequiresApi

@SuppressLint("AppCompatCustomView")
class VerticalSeekBar : SeekBar {
    constructor(context: Context) : super(context){}
    constructor(context: Context, attributes: AttributeSet) : super(context, attributes){}
    constructor(context: Context, attributes: AttributeSet, styleAttr: Int) :
            super(context, attributes,styleAttr){}
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attributes: AttributeSet, styleAttr: Int, styleRes: Int) :
            super(context, attributes,styleAttr,styleRes){}

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(heightMeasureSpec, widthMeasureSpec)
        setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth())
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(h, w, oldh, oldw)
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.rotate(-90f);
        canvas?.translate(-getHeight().toFloat(),0f);
        super.onDraw(canvas)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return super.onTouchEvent(event)
    }
}