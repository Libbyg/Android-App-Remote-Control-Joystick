package com.example.joystick.views

import android.view.SurfaceView
import android.view.SurfaceHolder
import android.content.Context
import android.util.AttributeSet

class JoystickView : SurfaceView, SurfaceHolder.Callback {
    constructor(context: Context) : super(context){}
    constructor(context: Context, attributes: AttributeSet) : super(context, attributes){}
    constructor(context: Context, attributes: AttributeSet, style: Int) : super(context, attributes,style){}
    override fun surfaceCreated(holder: SurfaceHolder){}
    override fun surfaceChanged(holder: SurfaceHolder,format: Int, width: Int, height: Int){}
    override fun surfaceDestroyed(holder: SurfaceHolder){}
}