package com.example.joystick.views

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.PointF
import android.os.Build
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewPropertyAnimator
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.SeekBar
import androidx.annotation.RequiresApi
import com.example.joystick.R

//import android.view.SurfaceView
//import android.view.SurfaceHolder
//import android.content.Context
//import android.util.AttributeSet

//class JoystickView : SurfaceView, SurfaceHolder.Callback {
//    constructor(context: Context) : super(context){}
//    constructor(context: Context, attributes: AttributeSet) : super(context, attributes){}
//    constructor(context: Context, attributes: AttributeSet, style: Int) : super(context, attributes,style){}
//    override fun surfaceCreated(holder: SurfaceHolder){}
//    override fun surfaceChanged(holder: SurfaceHolder,format: Int, width: Int, height: Int){}
//    override fun surfaceDestroyed(holder: SurfaceHolder){}
//}

class JoystickView : FrameLayout{
    private lateinit var imageView: ImageView
    private lateinit var frameLayout: FrameLayout
    constructor(context: Context) : super(context){
        initView(context)
    }
    constructor(context: Context, attributes: AttributeSet) : super(context, attributes){
        initView(context)
    }
    constructor(context: Context, attributes: AttributeSet, styleAttr: Int) : super(context, attributes,styleAttr){
        initView(context)
    }
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attributes: AttributeSet, styleAttr: Int, styleRes: Int) : super(context, attributes,styleAttr,styleRes){
        initView(context)
    }
    @SuppressLint("ClickableViewAccessibility")
    private fun initView(context: Context){
        inflate(context, R.layout.joystick_layout, this)
        imageView = findViewById(R.id.imageView)
        frameLayout = findViewById(R.id.frameLayout)
        imageView.setOnTouchListener(object : View.OnTouchListener {
            private var DownPT: PointF = PointF() // Record Mouse Position When Pressed Down
            private var StartPT: PointF = PointF() // Record Start Position of 'view'
            private var animator: ViewPropertyAnimator? = null
            override fun onTouch(view: View, event: MotionEvent): Boolean {
                when (event.getAction().and(MotionEvent.ACTION_MASK)){
                    MotionEvent.ACTION_DOWN -> {
                        animator?.cancel()
                        DownPT.set( event.getRawX(), event.getRawY() )
                        StartPT.set( view.getX(), view.getY() )
                    }
                    MotionEvent.ACTION_UP -> {
                        animator = view.animate().translationX(0f).translationY(0f).setDuration(2000)
                    }
                    MotionEvent.ACTION_MOVE -> {
                        view.setX(StartPT.x + event.getRawX() - DownPT.x)
                        view.setY(StartPT.y + event.getRawY() - DownPT.y)
                    }
                }
                //view.invalidate()
                return true
            }
        })
    }
}