package com.example.joystick

import android.annotation.SuppressLint
import android.graphics.PointF
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.ViewPropertyAnimator
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.SeekBar

class MainActivity : AppCompatActivity() {
//    private lateinit var imageView: ImageView
//    private lateinit var frameLayout: FrameLayout

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        imageView = findViewById(R.id.imageView)
//        frameLayout = findViewById(R.id.frameLayout)
//
//        imageView.setOnTouchListener(object : View.OnTouchListener {
//            private var DownPT: PointF = PointF() // Record Mouse Position When Pressed Down
//            private var StartPT: PointF = PointF() // Record Start Position of 'view'
//            private var animator: ViewPropertyAnimator? = null
//            override fun onTouch(view: View ,event: MotionEvent): Boolean {
//                when (event.getAction().and(MotionEvent.ACTION_MASK)){
//                    MotionEvent.ACTION_DOWN -> {
//                        animator?.cancel()
//                        DownPT.set( event.getRawX(), event.getRawY() )
//                        StartPT.set( view.getX(), view.getY() )
//                    }
//                    MotionEvent.ACTION_UP -> {
//                        animator = view.animate().translationX(0f).translationY(0f).setDuration(2000)
//                    }
//                    MotionEvent.ACTION_MOVE -> {
//                        view.setX(StartPT.x + event.getRawX() - DownPT.x)
//                        view.setY(StartPT.y + event.getRawY() - DownPT.y)
//                    }
//                }
//                //view.invalidate()
//                return true
//            }
//        })
    }
}
