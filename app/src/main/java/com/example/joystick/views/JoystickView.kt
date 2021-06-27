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
import androidx.annotation.RequiresApi
import com.example.joystick.R
import timber.log.Timber

class JoystickView : FrameLayout{
    fun interface OnChangeListener {
        fun onChange(aileron: Float, elevator: Float)
    }
    var onChangeListener: OnChangeListener = OnChangeListener{aileron: Float, elevator: Float ->
    }
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
                        onChangeListener.onChange(0f, 0f)
                    }
                    MotionEvent.ACTION_MOVE -> {
                        view.setX(StartPT.x + event.getRawX() - DownPT.x)
                        view.setY(StartPT.y + event.getRawY() - DownPT.y)
                        onChangeListener.onChange(view.translationX/((view.parent as View).width/2f), view.translationY/((view.parent as View).height/2f))
                    }
                }
                return true
            }
        })
    }
}